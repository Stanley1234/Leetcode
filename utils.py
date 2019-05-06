from typing import List

from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver

import json

from model import Question, UserStatus, Submission


def login_via_password(driver, username, password):
    driver.get("https://leetcode.com/accounts/github/login/?next=%2Fproblems")

    WebDriverWait(driver, 20).until(EC.presence_of_element_located((
        By.ID, "username-input"
    )))
    WebDriverWait(driver, 20).until(EC.presence_of_element_located((
        By.ID, "password-input"
    )))
    WebDriverWait(driver, 20).until(EC.invisibility_of_element((
        By.ID, "initial-loading"
    )))

    username_input = driver.find_element_by_id("username-input")
    password_input = driver.find_element_by_id("password-input")
    search = driver.find_element_by_id("sign-in-button")

    username_input.send_keys(username)
    password_input.send_keys(password)

    search.click()


def login_via_github(driver, username, password):
    driver.get("https://leetcode.com/accounts/github/login/?next=%2Fproblems")

    wait = WebDriverWait(driver, 20)
    wait.until(EC.presence_of_element_located((By.ID, "login_field")))
    wait.until(EC.presence_of_element_located((By.ID, "password")))
    wait.until(EC.presence_of_element_located((By.NAME, "commit")))

    login_field = driver.find_element_by_id("login_field")
    password_input = driver.find_element_by_id("password")
    commit_btn = driver.find_element_by_name("commit")

    login_field.send_keys(username)
    password_input.send_keys(password)
    commit_btn.click()


def is_question_accepted(question_stat):
    return question_stat["status"] == "ac"


def is_question_paid(question_stat):
    return question_stat["paid_only"]


def build_question_from_question_stat(question_stat):
    qid = question_stat["stat"]["question_id"]
    title = question_stat["stat"]["question__title"]
    title_slug = question_stat["stat"]["question__title_slug"]
    level = question_stat["difficulty"]["level"]
    return Question(qid, title, title_slug, level)


def build_user_status(driver: webdriver):
    driver.get("https://leetcode.com/api/problems/algorithms/")
    body = driver.find_element_by_tag_name("body").get_attribute("innerHTML")
    body_json = json.loads(body)

    num_solved = body_json["num_solved"]
    ac_easy = body_json["ac_easy"]
    ac_medium = body_json["ac_medium"]
    ac_hard = body_json["ac_hard"]

    question_stats = body_json["stat_status_pairs"]
    ac_questions = []
    for question_stat in question_stats:
        if not is_question_accepted(question_stat) or is_question_paid(question_stat):
            continue
        question = build_question_from_question_stat(question_stat)
        ac_questions.append(question)

    user_status = UserStatus(num_solved, ac_easy, ac_medium, ac_hard, ac_questions)
    return user_status


def _read_synced_questions():
    question_titles = set()

    try:
        reader = open(".synced_questions", "r")
        for line in reader:
            question_titles.add(line.rstrip('\n'))
    except:
        pass

    return question_titles


def _parse_solution(driver: webdriver, submission_id):
    submission_detail_url = "https://leetcode.com/submissions/detail/%s" % submission_id
    driver.get(submission_detail_url)

    WebDriverWait(driver, 20).until(EC.presence_of_element_located((
        By.CSS_SELECTOR, "div[class~='ace_layer']"
    )))

    ace_line_groups = driver.find_elements_by_css_selector("div[class~='ace_layer'] > div[class='ace_line_group']")
    code_lines = []
    for ace_line_group in ace_line_groups:
        ace_lines = ace_line_group.find_elements_by_css_selector("div[class='ace_line']")
        code_line = ''.join([ace_line.text for ace_line in ace_lines])
        code_lines.append(code_line)

    codes = "\n".join(code_lines)
    return codes


def _detect_suffix(code_lang):
    code_lang = code_lang.lower()
    if code_lang == 'java':
        return 'java'
    elif code_lang == 'c++' or code_lang == 'cpp':
        return 'cpp'
    elif code_lang == 'python' or code_lang == 'python3':
        return 'py'
    elif code_lang == 'c':
        return 'c'
    elif code_lang == 'javascript':
        return 'js'
    else:
        raise NameError("unrecognized code lang: %s" % code_lang)


def _write_solution(solution_fnm, solution):
    with open(solution_fnm, "w") as writer:
        writer.write(solution)


def _journal_synced_question(question_title):
    with open(".synced_questions", "a") as writer:
        writer.write("%s\n" % question_title)


def download_submissions(driver: webdriver, user_status: UserStatus):
    try:
        synced_questions = _read_synced_questions()

        questions = user_status.ac_questions
        wait = WebDriverWait(driver, 20)
        for question in questions:
            # check if the question has been synced before
            if question.title in synced_questions:
                print("%s has been synced" % question.title)
                continue

            # find all accepted submissions for this question
            submission_url = "https://leetcode.com/problems/%s/submissions" % question.title_slug

            driver.get(submission_url)
            wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, 'tr[class~="ant-table-row"]')))

            submission_rows = driver.find_elements_by_css_selector('tr[class~="ant-table-row"]')
            submissions = []
            for submission_row in submission_rows:
                status = submission_row.find_element_by_css_selector('td[class^="status"] > a').text
                if status != "Accepted":
                    continue

                submission_id = submission_row.get_attribute("data-row-key")
                runtime = submission_row.find_element_by_css_selector('td[class^="runtime"]').text
                memory = submission_row.find_element_by_css_selector('td[class^="memory"]').text
                lang = submission_row.find_element_by_css_selector('td[class^="lang"]').text
                submission = Submission(submission_id, runtime, memory, lang)

                submissions.append(submission)
                print("Question: %s, Found accepted submission: %s" % (question.title, submission.submission_id))

            for submission in submissions:
                solution = _parse_solution(driver, submission.submission_id)
                solution_suffix = _detect_suffix(submission.language)
                solution_fnm = "solutions/%s_%s.%s" % (question.title, submission.language, solution_suffix)

                _write_solution(solution_fnm, solution)

                submission.solution_local_path = solution_fnm
                question.add_submission(submission.language, submission)
                print("Question: %s, Submission: %s sync completed" % (question.title, submission.submission_id))

            _journal_synced_question(question.title)
            yield question

            from time import sleep
            sleep(1)

    except Exception as e:
        print("An error occurred: %s" % str(e))
        yield None


def _generate_markdown_row(qid, title, language, runtime, memory, code_link):
    return '%s | %s | Accepted | %s | %s | %s | [code](%s)\n' % (
        qid, title, language, runtime, memory, code_link
    )


def generate_readme(questions: List[Question]):
    with open("readme_generated.md", "w") as writer:
        # table headers
        writer.write("Question Id | Title | Status | Language | Runtime | Memory | Code\n")
        writer.write("------------|-------|--------|----------|---------|--------|-----\n")

        for question in questions:
            for _, submission in question.submissions.items():
                row = _generate_markdown_row(
                    question.qid, question.title,
                    submission.language, submission.runtime, submission.memory,
                    submission.solution_local_path)
                writer.write(row)
