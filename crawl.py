from selenium import webdriver
from utils import login_via_github, build_user_status, \
    download_submissions, generate_readme


def read_local_auth():
    """
    Read the username and password information for leetcode account
    """

    with open(".leetcode-auth") as reader:
        username = next(reader).rstrip('\n')
        password = next(reader).rstrip('\n')

    return {
        "username": username,
        "password": password
    }


def crawl(leetcode_auth):
    driver = webdriver.Chrome(executable_path='chromedriver.exe')

    username = leetcode_auth["username"]
    password = leetcode_auth["password"]
    login_via_github(driver, username, password)

    # parse all questions already completed by the user
    user_status = build_user_status(driver)
    # download solutions for all completed questions
    # moreover, in case that the IP is blocked before syncing all problems
    # it yields a question once submissions for that question are all synced
    download_generator = download_submissions(driver, user_status)
    downloaded_questions = []
    for question in download_generator:
        downloaded_questions.append(question)
    generate_readme(downloaded_questions)

    from time import sleep
    sleep(2000)


if __name__ == "__main__":
    crawl(read_local_auth())
