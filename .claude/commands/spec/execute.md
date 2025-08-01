# Spec Execute Command

Execute specific tasks from the Github issue.

## Usage

```
/spec:execute [feature-name] [github-issue-id]
```

## Instructions

You are executing implementation tasks from the spec workflow.

1. **Prerequisites**

    - Load requirements.md, design.md, tasks.md and Github issue for context
    - Identify the specific task to execute
    - **CRITICAL**: Change a Github project task status to `IN PROGRESS`
    - **CRITICAL**: Create a Git branch from the Github issue

2. **Task Execution**

    - Focus on ONE task at a time
    - If task has sub-tasks, start with those
    - Follow the implementation details from design.md
    - Verify against requirements specified in the task

3. **Implementation Guidelines**

    - Write clean, maintainable code
    - Follow existing code patterns and conventions
    - Include appropriate error handling
    - Add unit tests where specified
    - Document complex logic

4. **Validation**

    - Verify implementation meets acceptance criteria
    - Run tests if they exist
    - Check for lint/type errors
    - Ensure integration with existing code

5. **Completion**
    - **CRITICAL**: After task completion, create a Github pull request
    - Update execution log with completion details
    - Stop and wait for user review
    - DO NOT automatically proceed to next task
    - Confirm task completion status to user by creating a Github pull request

## Examples

```
/spec:execute user-authentication 1
/spec:execute user-authentication 2
```

## Important Rules

- Only execute ONE task at a time
- Before task start:
  - **ALWAYS** change Github project task status to `IN PROGESS`
  - **ALWAYS** create a Git branch from the Github issue
- **ALWAYS** create a Github pull request after task completion
- Always stop after completing a task
- Wait for user approval before continuing
- Never skip tasks or jump ahead
- Confirm task completion status to user by creating a Github pull request
