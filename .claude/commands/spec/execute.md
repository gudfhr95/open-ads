# Spec Execute Command

Execute specific tasks from the JIRA task list.

## Usage

```
/spec:execute [feature-name] [jira-issue-id]
```

## Instructions

You are executing implementation tasks from the spec workflow.

1. **Prerequisites**

   - Ensure tasks.md exists and is approved
   - Load requirements.md, design.md, tasks.md and JIRA issue for context
   - Identify the specific task to execute

2. **Task Execution**

   - **CRITICAL**: Before starting the task, change JIRA issue status to `IN PROGRESS`
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
   - **CRITICAL**: After task completion, create a Github pull request to get code review from user
   - Update execution log with completion details
   - Stop and wait for user review
   - DO NOT automatically proceed to next task
   - Confirm task completion status to user

## Task Selection

If no jira-issue-id specified:

- Look at tasks.md and JIRA issues for the spec
- Recommend the next pending task
- Ask user to confirm before proceeding

## Examples

```
/spec:execute user-authentication AD-12345
/spec:execute user-authentication AD-23456
```

## Important Rules

- Only execute ONE task at a time
- Before task start, **ALWAYS** change JIRA issue status to `IN PROGESS`
- **ALWAYS** create a Github pull request after task completion
- Always stop after completing a task
- Wait for user approval before continuing
- Never skip tasks or jump ahead
- Confirm task completion status to user
