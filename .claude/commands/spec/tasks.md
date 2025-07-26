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
    - **Prioritize extending/adapting existing code** over building from scratch
    - Use numbered hierarchy
    - Each task should reference specific requirements AND existing code to leverage
    - Focus ONLY on coding tasks (no deployment, user testing, etc.)

3. **Task Guidelines**

    - Tasks should be concrete and actionable
    - **Reference existing code to reuse**: Include specific files/components to extend or adapt
    - Include specific file names and components
    - Build incrementally (each task builds on previous)
    - Reference requirements using _Requirements: X.Y_ format
    - Use test-driven development approach leveraging existing test patterns
    - Each task should be organized as a unit of deployment
    - After the task is done, it should be deployable

4. **Task Format**

   ```markdown
   1. Task description
     - Sub-bullet with details
     - Specific files to create/modify
     - _Leverage: existing-component.ts, utils/helpers.js_
     - _Requirements: 1.1, 2.3_
   ```

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

7. **Generate Github Project tasks and Github Issues** (ONLY after tasks approval)
    - **WAIT**: Do not create Github project tasks and Github issues until user explicitly approves tasks
    - **THEN EXECUTE**
        - Based on tasks.md, create Github project tasks
        - Create Github issues from Github project tasks
        - Link Github issues according to task hierarchy
    - **PURPOSE**: For tracking task process
    - **RESULT**: Github project tasks and issues created with proper hierarchy
    - **IMPORTANT RULES**: Each task must have proper title, description, label, hierarchical relationship and extra
      properties.

## Task Structure

```markdown
# Implementation Plan

1. Setup project structure
    - Create directory structure following existing patterns
    - Define core interfaces extending existing base classes
    - _Leverage: src/types/base.ts, src/models/BaseModel.ts_
    - _Requirements: 1.1_

2. Implement data models
   2.1. Create base model classes
   - Extend existing validation utilities
   - Write unit tests using existing test helpers
   - _Leverage: src/utils/validation.ts, tests/helpers/testUtils.ts_
   - _Requirements: 2.1, 2.2_
```

## Next Phase

After approval:

- Use `/spec:execute` to implement tasks
- Check progress with `/spec:status {feature-name}`
