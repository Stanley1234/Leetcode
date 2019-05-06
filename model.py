

class Submission(object):
    """
    Instance fields:
        submission_id
        runtime
        memory
        language
        solution_local_path
    """
    def __init__(self, submission_id, runtime, memory, language):
        self.submission_id = submission_id
        self.runtime = runtime
        self.memory = memory
        self.language = language


class QuestionStatus(object):
    UNDONE = 0
    ACCEPTED = 1
    WRONG_ANSWER = 2


class Question(object):
    """
    Instance fields:
        qid
        title
        title_slug
        level
        status
        submissions
    """
    def __init__(self, qid, title, title_slug, level, status=QuestionStatus.ACCEPTED):
        self.qid = qid
        self.title = title
        self.title_slug = title_slug
        self.level = level
        self.status = status

        # mutable
        self.submissions = {}

    def add_submission(self, code_language: str, submission: Submission, override=False):
        if not override and code_language in self.submissions:
            return
        self.submissions[code_language] = submission


class UserStatus(object):
    """
    Instance fields:
        num_solved
        ac_easy
        ac_medium
        ac_hard
        ac_questions
    """
    def __init__(self, num_solved, ac_easy, ac_medium, ac_hard, ac_questions):
        self.num_solved = num_solved
        self.ac_easy = ac_easy
        self.ac_medium = ac_medium
        self.ac_hard = ac_hard
        self.ac_questions = ac_questions
