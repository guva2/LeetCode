#!/usr/bin/env python3

from string import Template
import re
import os
import shutil

PROBLEM_NAME_REGEX = re.compile(r'^[0-9A-Z-a-z ]+$')
CAMEL_CASE_WORD_BREAK_REGEX = re.compile(r'(?<!^)(?=[A-Z])')
MAIN_PATH = 'src/main/java/me/guva/leetcode'
TEST_PATH = 'src/test/java/me/guva/leetcode'
README_FILE_NAME = 'README'
MAIN_FILE_NAME = 'Solution.java'
TEST_FILE_NAME = 'SolutionTest.java'
TEMPLATE_DIR = '0-template'
README_TEMPLATE_PATH_NAME = f'{TEMPLATE_DIR}/README.template'
MAIN_TEMPLATE_PATH_NAME = f'{TEMPLATE_DIR}/Solution.template'
TEST_TEMPLATE_PATH_NAME = f'{TEMPLATE_DIR}/SolutionTest.template'
GRADLE_TEMPLATE_PATH_NAME = f'{TEMPLATE_DIR}/build.gradle'
GRADLE_SETTINGS_PATH_NAME = 'settings.gradle'
GRADLE_SETTING_TEMPLATE = Template('include \'$dir_name\'\n')

def get_problem_identifiers():
    problem_number = int(input('Enter the LeetCode problem number.\n').strip())
    problem_name = input('Enter the LeetCode problem name.\n').strip()
    if not PROBLEM_NAME_REGEX.match(problem_name):
        raise ValueError(f'{problem_name} mismatches {PROBLEM_NAME_REGEX}.')
    return (problem_number, problem_name)

def get_method_parameters():
    method_name = input('Enter the method name.\n').strip()
    output_parameter = input('Enter the output object type.\n').strip()
    input_parameters = input('Enter the input parameters.\n').strip()
    return (method_name, output_parameter, input_parameters)

def build_hyphenated_problem_name(problem_name):
    return problem_name.lower().replace(' ', '-')

def build_root_dir_name(problem_number, problem_name):
    hyphenated_problem_name = build_hyphenated_problem_name(problem_name)
    return f'{problem_number}-{hyphenated_problem_name}'

def build_package_name(method_name):
    return CAMEL_CASE_WORD_BREAK_REGEX.sub('_', method_name).lower()

def build_template_dict(problem_name, package_name, method_name,
                        output_parameter, input_parameters):
    return {
        'problem_name': problem_name,
        'hyphenated_problem_name': build_hyphenated_problem_name(problem_name),
        'package_name': package_name,
        'method_name': method_name,
        'output_parameter': output_parameter,
        'input_parameters': input_parameters
    }


def build_path(*subpaths):
    return '/'.join(subpaths)

def build_main_path(root_dir_name, package_name):
    return build_path(root_dir_name, MAIN_PATH, package_name)

def build_test_path(root_dir_name, package_name):
    return build_path(root_dir_name, TEST_PATH, package_name)

def build_code_paths(root_dir_name, package_name):
    return (root_dir_name, package_name)

def make_root_dir(root_dir_name):
    os.mkdir(root_dir_name)

def make_code_dirs(path):
    os.makedirs(path, exist_ok=True)

def write_template_file(file_name, template_name, template_dict):
    with open(template_name, 'r') as template_f, open(file_name, 'w') as f:
        template = Template(template_f.read())
        output = template.substitute(template_dict)
        f.write(output)

def generate_root_dir(problem_number, problem_name):
    root_dir_name = build_root_dir_name(problem_number, problem_name)
    make_root_dir(root_dir_name)

def generate_main_file(root_dir_name, package_name, template_dict):
    main_path = build_main_path(root_dir_name, package_name)
    make_code_dirs(main_path)
    main_path_name = f'{main_path}/{MAIN_FILE_NAME}'
    write_template_file(main_path_name, MAIN_TEMPLATE_PATH_NAME, template_dict)

def generate_test_file(root_dir_name, package_name, template_dict):
    test_path = build_test_path(root_dir_name, package_name)
    make_code_dirs(test_path)
    test_path_name = f'{test_path}/{TEST_FILE_NAME}'
    write_template_file(test_path_name, TEST_TEMPLATE_PATH_NAME, template_dict)

def generate_readme_file(root_dir_name, template_dict):
    readme_path_name = f'{root_dir_name}/{README_FILE_NAME}'
    write_template_file(readme_path_name, README_TEMPLATE_PATH_NAME, template_dict)

def generate_code_files(root_dir_name, package_name, template_dict):
    generate_main_file(root_dir_name, package_name, template_dict)
    generate_test_file(root_dir_name, package_name, template_dict)

def copy_gradle_build_file(root_dir_name):
    shutil.copy(GRADLE_TEMPLATE_PATH_NAME, root_dir_name)

def generate_files(problem_number, problem_name, package_name, template_dict):
    root_dir_name = build_root_dir_name(problem_number, problem_name)
    generate_readme_file(root_dir_name, template_dict)
    generate_code_files(root_dir_name, package_name, template_dict)
    copy_gradle_build_file(root_dir_name)
    update_gradle_settings_file(root_dir_name)

def update_gradle_settings_file(root_dir_name):
    gradle_setting = GRADLE_SETTING_TEMPLATE.substitute(dir_name=root_dir_name)
    with open(GRADLE_SETTINGS_PATH_NAME, 'r+') as file:
        if gradle_setting not in file.read():
            file.write(gradle_setting)

def main():
    problem_number, problem_name = get_problem_identifiers()
    generate_root_dir(problem_number, problem_name)
    method_name, output_parameter, input_parameters = get_method_parameters()
    package_name = build_package_name(method_name)
    template_dict = build_template_dict(problem_name,
                                        package_name,
                                        method_name,
                                        output_parameter,
                                        input_parameters)
    generate_files(problem_number, problem_name, package_name, template_dict)

if __name__ == '__main__':
    main()
