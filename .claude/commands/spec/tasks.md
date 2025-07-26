# Spec Tasks Command

Generate implementation task list based on approved design.

## Usage

```
/spec:tasks [feature-name]
```

## Instructions

You are working on the tasks phase of the spec workflow.

**WORKFLOW**: This is the FINAL step before command generation.
**SEQUENCE**: Create Tasks → Get Approval → THEN run script
**DO NOT** run any scripts until tasks are approved.

1. **Prerequisites**

    - Ensure design.md exists and is approved
    - Load both requirements.md and design.md for context
    - Understand the complete feature scope

2. **Generate Task List** (prioritize code reuse)

    - Break design into atomic, executable coding tasks
    - **IMPORTANT**: Tasks should be concrete, actionable, deployable and production-ready
    - **Prioritize extending/adapting existing code** over building from scratch
    - Use numbered hierarchy
    - Each task should reference specific requirements AND existing code to leverage
    - Focus ONLY on coding tasks (no deployment, user testing, etc.)

3. **Task Guidelines**

    - Tasks should be concrete and actionable
    - **IMPORTANT**: After task completion, code must be production-ready and deployable
    - **Reference existing code to reuse**: Include specific files/components to extend or adapt
    - Include specific file names and components
    - Build incrementally (each task builds on previous)
    - Reference requirements using _Requirements: X.Y_ format
    - Use test-driven development approach leveraging existing test patterns

4. **Task Format**

    - Use template (@tasks-template.md)

5. **Excluded Tasks**

    - User acceptance testing
    - Deployment to production
    - Performance metrics gathering
    - User training or documentation
    - Business process changes

6. **Approval Process**

    - Present the complete task list and write it to tasks.md
    - Ask: "Do the tasks look good?"
    - Make revisions based on feedback
    - Continue until explicit approval

7. **Generate Github Issues and Github Project tasks** (ONLY after tasks approval)
    - **WAIT**: Do not create Github issues and Github project tasks until user explicitly approves tasks
    - **THEN EXECUTE**
        - Based on tasks.md, create Github issues
        - Add issues in Github project
    - **PURPOSE**: For tracking task process
    - **RESULT**: Github issues and Github project tasks with proper hierarchy
    - **IMPORTANT RULES**
        - Each issue must have proper title, description and label
        - If task has sub-tasks, create sub-tasks as sub-issues
        - Do not create new Github project. Use existing project.
        - When adding Github issues to Github project, fill in property fields like status, priority, etc.

## Task Structure

- Use template (@tasks-template.md)

## Next Phase

After approval:

- Use `/spec:execute` to implement tasks
- Check progress with `/spec:status {feature-name}`
