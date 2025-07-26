# MCP.md - SuperClaude MCP Server Reference

MCP (Model Context Protocol) server integration and orchestration system for Claude Code SuperClaude framework.

## Server Selection Algorithm

**Priority Matrix**:

1. Task-Server Affinity: Match tasks to optimal servers based on capability matrix
2. Performance Metrics: Server response time, success rate, resource utilization
3. Context Awareness: Current persona, command depth, session state
4. Load Distribution: Prevent server overload through intelligent queuing
5. Fallback Readiness: Maintain backup servers for critical operations

**Selection Process**: Task Analysis → Server Capability Match → Performance Check → Load Assessment → Final Selection

## Context7 Integration (Documentation & Research)

**Purpose**: Official library documentation, code examples, best practices, localization standards

**Activation Patterns**:

- Automatic: External library imports detected, framework-specific questions, scribe persona active
- Manual: `--c7`, `--context7` flags
- Smart: Commands detect need for official documentation patterns

**Workflow Process**:

1. Library Detection: Scan imports, dependencies, package.json for library references
2. ID Resolution: Use `resolve-library-id` to find Context7-compatible library ID
3. Documentation Retrieval: Call `get-library-docs` with specific topic focus
4. Pattern Extraction: Extract relevant code patterns and implementation examples
5. Implementation: Apply patterns with proper attribution and version compatibility
6. Validation: Verify implementation against official documentation
7. Caching: Store successful patterns for session reuse

**Integration Commands**: `/spec:create`, `/spec:requirements`, `/spec:design`, `/spec:tasks`, `/spec:execute`, `/sc:build`, `/sc:analyze`, `/sc:improve`, `/sc:design`, `/sc:document`, `/sc:explain`, `/sc:git`

**Error Recovery**:

- Library not found → WebSearch for alternatives → Manual implementation
- Documentation timeout → Use cached knowledge → Note limitations
- Invalid library ID → Retry with broader search terms → Fallback to WebSearch
- Version mismatch → Find compatible version → Suggest upgrade path
- Server unavailable → Activate backup Context7 instances → Graceful degradation

## Sequential Integration (Complex Analysis & Thinking)

**Purpose**: Multi-step problem solving, architectural analysis, systematic debugging

**Activation Patterns**:

- Automatic: Complex debugging scenarios, system design questions, `--think` flags
- Manual: `--seq`, `--sequential` flags
- Smart: Multi-step problems requiring systematic analysis

**Workflow Process**:

1. Problem Decomposition: Break complex problems into analyzable components
2. Server Coordination: Coordinate with Context7 for documentation, Magic for UI insights, Playwright for testing
3. Systematic Analysis: Apply structured thinking to each component
4. Relationship Mapping: Identify dependencies, interactions, and feedback loops
5. Hypothesis Generation: Create testable hypotheses for each component
6. Evidence Gathering: Collect supporting evidence through tool usage
7. Multi-Server Synthesis: Combine findings from multiple servers
8. Recommendation Generation: Provide actionable next steps with priority ordering
9. Validation: Check reasoning for logical consistency

**Integration with Thinking Modes**:

- `--think` (4K): Module-level analysis with context awareness
- `--think-hard` (10K): System-wide analysis with architectural focus
- `--ultrathink` (32K): Critical system analysis with comprehensive coverage

**Use Cases**:

- Root cause analysis for complex bugs
- Performance bottleneck identification
- Architecture review and improvement planning
- Security threat modeling and vulnerability analysis
- Code quality assessment with improvement roadmaps
- Scribe Persona: Structured documentation workflows, multilingual content organization
- Loop Command: Iterative improvement analysis, progressive refinement planning

## Magic Integration (UI Components & Design)

**Purpose**: Modern UI component generation, design system integration, responsive design

**Activation Patterns**:

- Automatic: UI component requests, design system queries
- Manual: `--magic` flag
- Smart: Frontend persona active, component-related queries

**Workflow Process**:

1. Requirement Parsing: Extract component specifications and design system requirements
2. Pattern Search: Find similar components and design patterns from 21st.dev database
3. Framework Detection: Identify target framework (React, Vue, Angular) and version
4. Server Coordination: Sync with Context7 for framework patterns, Sequential for complex logic
5. Code Generation: Create component with modern best practices and framework conventions
6. Design System Integration: Apply existing themes, styles, tokens, and design patterns
7. Accessibility Compliance: Ensure WCAG compliance, semantic markup, and keyboard navigation
8. Responsive Design: Implement mobile-first responsive patterns
9. Optimization: Apply performance optimizations and code splitting
10. Quality Assurance: Validate against design system and accessibility standards

**Component Categories**:

- Interactive: Buttons, forms, modals, dropdowns, navigation, search components
- Layout: Grids, containers, cards, panels, sidebars, headers, footers
- Display: Typography, images, icons, charts, tables, lists, media
- Feedback: Alerts, notifications, progress indicators, tooltips, loading states
- Input: Text fields, selectors, date pickers, file uploads, rich text editors
- Navigation: Menus, breadcrumbs, pagination, tabs, steppers
- Data: Tables, grids, lists, cards, infinite scroll, virtualization

**Framework Support**:

- React: Hooks, TypeScript, modern patterns, Context API, state management
- Vue: Composition API, TypeScript, reactive patterns, Pinia integration
- Angular: Component architecture, TypeScript, reactive forms, services
- Vanilla: Web Components, modern JavaScript, CSS custom properties

## Playwright Integration (Browser Automation & Testing)

**Purpose**: Cross-browser E2E testing, performance monitoring, automation, visual testing

**Activation Patterns**:

- Automatic: Testing workflows, performance monitoring requests, E2E test generation
- Manual: `--play`, `--playwright` flags
- Smart: QA persona active, browser interaction needed

**Workflow Process**:

1. Browser Connection: Connect to Chrome, Firefox, Safari, or Edge instances
2. Environment Setup: Configure viewport, user agent, network conditions, device emulation
3. Navigation: Navigate to target URLs with proper waiting and error handling
4. Server Coordination: Sync with Sequential for test planning, Magic for UI validation
5. Interaction: Perform user actions (clicks, form fills, navigation) across browsers
6. Data Collection: Capture screenshots, videos, performance metrics, console logs
7. Validation: Verify expected behaviors, visual states, and performance thresholds
8. Multi-Server Analysis: Coordinate with other servers for comprehensive test analysis
9. Reporting: Generate test reports with evidence, metrics, and actionable insights
10. Cleanup: Properly close browser connections and clean up resources

**Capabilities**:

- Multi-Browser Support: Chrome, Firefox, Safari, Edge with consistent API
- Visual Testing: Screenshot capture, visual regression detection, responsive testing
- Performance Metrics: Load times, rendering performance, resource usage, Core Web Vitals
- User Simulation: Real user interaction patterns, accessibility testing, form workflows
- Data Extraction: DOM content, API responses, console logs, network monitoring
- Mobile Testing: Device emulation, touch gestures, mobile-specific validation
- Parallel Execution: Run tests across multiple browsers simultaneously

**Integration Patterns**:

- Test Generation: Create E2E tests based on user workflows and critical paths
- Performance Monitoring: Continuous performance measurement with threshold alerting
- Visual Validation: Screenshot-based testing and regression detection
- Cross-Browser Testing: Validate functionality across all major browsers
- User Experience Testing: Accessibility validation, usability testing, conversion optimization

## Atlassian Integration (Confluence & Jira)

**Purpose**: Enterprise documentation management, agile project tracking, team collaboration, knowledge base creation

**Activation Patterns**:

- Keywords: "confluence", "jira", "ticket", "epic", "story", "sprint", "backlog", "confluence page", "jira issue", "atlassian"
- Smart: URLs containing `atlassian.net`, spec workflow active, agile project management context

**Workflow Process**:

1. Cloud ID Resolution: Extract from URL or use `getAccessibleAtlassianResources` to find accessible instances
2. Space/Project Discovery: List available Confluence spaces or Jira projects based on permissions
3. Content Creation: Generate structured documentation or issues with proper formatting
4. Hierarchy Management: Handle parent-child relationships for pages and epic-story-task structures
5. Search & Discovery: Use CQL/JQL for advanced querying across content and issues
6. Cross-Linking: Automatically link Jira issues to Confluence pages and vice versa
7. Status Management: Track and transition issues through workflow states
8. Permission Handling: Respect space/project permissions and user access levels
9. Comment Integration: Add contextual comments to pages and issues
10. Bulk Operations: Handle batch updates and migrations efficiently

**Integration Commands**:

- `/spec:create` → Creates Confluence requirements page + Jira epic
- `/spec:tasks` → Generates Jira tasks linked to Confluence documentation
- `/spec:execute` → Updates Jira status and adds execution notes
- `/sc:document` → Creates/updates Confluence pages with navigation
- `/sc:git` → Links commits to Jira issues, updates ticket status
- `/sc:analyze` → Documents findings in Confluence with Jira tracking

**Use Cases**:

- **Requirements Management**: Create linked requirements in Confluence with Jira tracking
- **Technical Documentation**: Generate API docs, architecture diagrams, runbooks
- **Sprint Planning**: Create and manage sprint tasks with linked documentation
- **Knowledge Base**: Build searchable team knowledge with categorization
- **Release Notes**: Auto-generate from Jira issues and Confluence pages
- **Incident Reports**: Document post-mortems with linked action items
- **Team Onboarding**: Create structured onboarding guides with task tracking

## Notion Integration

**Purpose**: Flexible workspace management, database-driven documentation, personal and team knowledge management

**Activation Patterns**:

- Keywords: "notion", "notion page", "notion database", "notion block", "notion table", "notion board", "notion calendar", "notion wiki", "notion workspace"
- Smart: URLs containing `notion.so`, database/table/board references, wiki-style documentation

**Workflow Process**:

1. Authentication: Validate Notion integration token and workspace access
2. Page/Database Resolution: Find target pages or databases using search or direct IDs
3. Content Structure: Convert markdown to Notion blocks with proper formatting
4. Property Management: Handle database properties, relations, and formulas
5. Hierarchical Organization: Create nested pages and maintain parent-child relationships
6. Block Operations: Add, update, delete blocks with type-specific handling
7. Database Queries: Filter, sort, and paginate database entries efficiently
8. Comment Threading: Manage page and inline comments with resolution tracking
9. Rich Content: Handle embeds, files, and multimedia content
10. Sync State: Track changes and maintain consistency across operations

**Integration Commands**:

- `/spec:create` → Builds project wikis with linked databases
- `/sc:task` → Creates Notion database entries for task management
- `/sc:document` → Generates structured Notion pages with TOC
- `/sc:analyze` → Creates analysis dashboards in Notion databases
- `/sc:build` → Documents build processes in Notion
- `/sc:improve` → Tracks improvements in Notion with progress metrics

**Use Cases**:

- **Project Wikis**: Create comprehensive project documentation with databases
- **Task Databases**: Build custom task management with views and filters
- **Knowledge Repository**: Organize team knowledge with tags and relations
- **Meeting Notes**: Structure meeting notes with action items database
- **Content Calendar**: Manage content pipeline with status tracking
- **Learning Resources**: Build educational content with progress tracking
- **Personal Dashboard**: Create unified workspace with multiple databases

## GitHub Integration

**Purpose**: Version control integration, pull request automation, issue tracking, CI/CD coordination

**Activation Patterns**:

- Keywords: "PR", "pull request", "github issue", "commit", "branch", "merge", "review", "github actions", "workflow", "release", "github"
- Smart: Git repository detected, PR/issue numbers (#123), GitHub URLs, CI/CD context

**Workflow Process**:

1. Repository Context: Detect current repository or resolve from URLs
2. Authentication: Use GitHub token or OAuth for API access
3. Branch Management: Create, update, and manage feature branches
4. Commit Creation: Generate meaningful commit messages with conventional format
5. Pull Request Flow: Create PRs with templates, descriptions, and metadata
6. Code Review: Add review comments, request changes, approve PRs
7. Issue Management: Create, update, label, and link issues to code
8. Workflow Automation: Trigger and monitor GitHub Actions workflows
9. Notification Handling: Process and respond to GitHub notifications
10. Release Management: Create releases with changelogs from commits/PRs

**Integration Commands**:

- `/sc:git` → Full git workflow with PR creation and issue linking
- `/spec:execute` → Creates PR for implementation with linked issues
- `/sc:analyze` → Adds code review comments and security findings
- `/sc:document` → Updates repository documentation and wikis
- `/sc:test` → Triggers test workflows and reports results
- `/sc:build` → Manages build artifacts and deployment workflows

**Use Cases**:

- **Feature Development**: Branch creation, implementation, PR with review
- **Code Review**: Automated and manual review with inline comments
- **Issue Tracking**: Link code changes to issues with auto-closure
- **CI/CD Management**: Trigger workflows, monitor runs, handle failures
- **Security Scanning**: Create security advisories and track vulnerabilities
- **Release Automation**: Generate releases with compiled changelogs
- **Documentation Updates**: Keep docs in sync with code changes
- **Dependency Management**: Track and update dependencies with PRs

## MCP Server Use Cases by Command Category

**Development Commands**:

- Context7: Framework patterns, library documentation
- Magic: UI component generation
- Sequential: Complex setup workflows
- Atlassian: Update Jira status during implementation, document builds in Confluence
- Notion: Document implementation progress, track features in databases
- GitHub: Create feature branches, manage PRs, link commits to issues

**Analysis Commands**:

- Context7: Best practices, patterns
- Sequential: Deep analysis, systematic review
- Playwright: Issue reproduction, visual testing
- Atlassian: Generate analysis reports in Confluence, create investigation tickets
- Notion: Create analysis dashboards, document findings in pages
- GitHub: Add code review comments, analyze security vulnerabilities

**Quality Commands**:

- Context7: Security patterns, improvement patterns
- Sequential: Code analysis, cleanup strategies
- Atlassian: Track improvements in Jira, document cleanup in Confluence
- Notion: Track quality metrics in databases, improvement roadmaps
- GitHub: Create quality-focused PRs, track technical debt issues

**Testing Commands**:

- Sequential: Test strategy development
- Playwright: E2E test execution, visual regression
- Atlassian: Create test plans in Confluence, track execution in Jira
- Notion: Test case databases, test result tracking
- GitHub: Trigger test workflows, report test results in PRs

**Documentation Commands**:

- Context7: Documentation patterns, style guides, localization standards
- Sequential: Content analysis, structured writing, multilingual documentation workflows
- Scribe Persona: Professional writing with cultural adaptation and language-specific conventions
- Atlassian: Primary Confluence page creation, knowledge base management
- Notion: Wiki creation, structured documentation with TOC
- GitHub: Update README files, maintain project wikis

**Planning Commands**:

- Context7: Benchmarks and patterns
- Sequential: Complex planning and estimation
- Atlassian: Create epics/stories in Jira, requirements in Confluence
- Notion: Project roadmaps, sprint planning databases
- GitHub: Milestone creation, project board management

**Deployment Commands**:

- Sequential: Deployment planning
- Playwright: Deployment validation
- Atlassian: Document deployment procedures, track releases in Jira
- Notion: Deployment checklists, release documentation
- GitHub: Manage deployment workflows, create releases

**Meta Commands**:

- Sequential: Search intelligence, task orchestration, iterative improvement analysis
- All MCP: Comprehensive analysis and orchestration
- Loop Command: Iterative workflows with Sequential (primary) and Context7 (patterns)
- Atlassian: Multi-team coordination with Confluence spaces, cross-project Jira queries
- Notion: Cross-workspace operations, unified dashboards
- GitHub: Multi-repo operations, organization-wide automation

## Server Orchestration Patterns

**Multi-Server Coordination**:

- Task Distribution: Intelligent task splitting across servers based on capabilities
- Dependency Management: Handle inter-server dependencies and data flow
- Synchronization: Coordinate server responses for unified solutions
- Load Balancing: Distribute workload based on server performance and capacity
- Failover Management: Automatic failover to backup servers during outages

**Caching Strategies**:

- Context7 Cache: Documentation lookups with version-aware caching
- Sequential Cache: Analysis results with pattern matching
- Magic Cache: Component patterns with design system versioning
- Playwright Cache: Test results and screenshots with environment-specific caching
- Cross-Server Cache: Shared cache for multi-server operations
- Loop Optimization: Cache iterative analysis results, reuse improvement patterns

**Error Handling and Recovery**:

- Context7 unavailable → WebSearch for documentation → Manual implementation
- Sequential timeout → Use native Claude Code analysis → Note limitations
- Magic failure → Generate basic component → Suggest manual enhancement
- Playwright connection lost → Suggest manual testing → Provide test cases

**Recovery Strategies**:

- Exponential Backoff: Automatic retry with exponential backoff and jitter
- Circuit Breaker: Prevent cascading failures with circuit breaker pattern
- Graceful Degradation: Maintain core functionality when servers are unavailable
- Alternative Routing: Route requests to backup servers automatically
- Partial Result Handling: Process and utilize partial results from failed operations

**Integration Patterns**:

- Minimal Start: Start with minimal MCP usage and expand based on needs
- Progressive Enhancement: Progressively enhance with additional servers
- Result Combination: Combine MCP results for comprehensive solutions
- Graceful Fallback: Fallback gracefully when servers unavailable
- Loop Integration: Sequential for iterative analysis, Context7 for improvement patterns
- Dependency Orchestration: Manage inter-server dependencies and data flow
