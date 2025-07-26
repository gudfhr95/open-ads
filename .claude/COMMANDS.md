# COMMANDS.md - SuperClaude Command Execution Framework

Command execution framework for Claude Code SuperClaude integration.

## Command System Architecture

### Core Command Structure

```yaml
---
command: "/{command-name}"
category: "Primary classification"
purpose: "Operational objective"
wave-enabled: true|false
performance-profile: "optimization|standard|complex"
---
```

### Command Processing Pipeline

1. **Input Parsing**: `$ARGUMENTS` with `@<path>`, `!<command>`, `--<flags>`
2. **Context Resolution**: Auto-persona activation and MCP server selection
3. **Wave Eligibility**: Complexity assessment and wave mode determination
4. **Execution Strategy**: Tool orchestration and resource allocation
5. **Quality Gates**: Validation checkpoints and error handling

### Integration Layers

- **Claude Code**: Native slash command compatibility
- **Persona System**: Auto-activation based on command context
- **MCP Servers**: Context7, Sequential, Magic, Playwright integration
- **Wave System**: Multi-stage orchestration for complex operations

## Wave System Integration

**Wave Orchestration Engine**: Multi-stage command execution with compound intelligence. Auto-activates on complexity
≥0.7 + files >20 + operation_types >2.

**Wave-Enabled Commands**:

- **Tier 1**: `/spec:execute`, `/sc:analyze`, `/sc:build`, `/sc:implement`, `/sc:improve`
- **Tier 2**: `/spec:create`, `/spec:requirements`, `/spec:design`, `/spec:tasks`, `/sc:design`, `/sc:task`

### Plan Commands

**`/spec:create $ARGUMENTS`**

```yaml
---
command: "/spec:create"
category: "Development & Planning"
purpose: "Create a new feature spec"
wave-enabled: true
performance-profile: "standard"
---
```

- **Auto-Persona**: Architect, Scribe
- **MCP Integration**: Context7 (patterns), Sequential (logic)
- **Tool Orchestration**: [Read, Write, Edit, MultiEdit, Bash, Glob, TodoWrite, Task]
- **Arguments**: `<feature-name>`, `[description]`, `--<flags>`

**`/spec:requirements $ARGUMENTS`**

```yaml
---
command: "/spec:requirements"
category: "Development & Planning"
purpose: "Generate requirements document"
wave-enabled: true
performance-profile: "standard"
---
```

- **Auto-Persona**: Architect, Scribe
- **MCP Integration**: Context7 (patterns), Sequential (logic)
- **Tool Orchestration**: [Read, Write, Edit, MultiEdit, Bash, Glob, TodoWrite, Task]
- **Arguments**: `<feature-name>`, `[description]`, `--<flags>`

### Development Commands

**`/spec:design $ARGUMENTS`**

```yaml
---
command: "/spec:design"
category: "Development & Planning"
purpose: "Generate design document"
wave-enabled: true
performance-profile: "standard"
---
```

- **Auto-Persona**: Backend, Architect, Scribe
- **MCP Integration**: Context7 (patterns), Sequential (logic)
- **Tool Orchestration**: [Read, Write, Edit, MultiEdit, Bash, Glob, TodoWrite, Task]
- **Arguments**: `<feature-name>`, `[description]`, `--<flags>`

**`/spec:tasks $ARGUMENTS`**

```yaml
---
command: "/spec:tasks"
category: "Development & Planning"
purpose: "Generate implementation tasks"
wave-enabled: true
performance-profile: "standard"
---
```

- **Auto-Persona**: Backend, Architect, Scribe
- **MCP Integration**: Context7 (patterns), Sequential (logic)
- **Tool Orchestration**: [Read, Write, Edit, MultiEdit, Bash, Glob, TodoWrite, Task]
- **Arguments**: `<feature-name>`, `[description]`, `--<flags>`

**`/spec:execute $ARGUMENTS`**

```yaml
---
command: "/spec:execute"
category: "Development"
purpose: "Execute specific task"
wave-enabled: true
performance-profile: "complex"
---
```

- **Auto-Persona**: Backend, Architect, Scribe, Security (context-dependent)
- **MCP Integration**: Context7 (patterns), Sequential (logic)
- **Tool Orchestration**: [Read, Write, Edit, MultiEdit, Bash, Glob, TodoWrite, Task]
- **Arguments**: `<feature-name>`, `[description]`, `--<flags>`

**`/sc:build $ARGUMENTS`**

```yaml
---
command: "/sc:build"
category: "Development & Deployment"
purpose: "Project builder with framework detection"
wave-enabled: true
performance-profile: "optimization"
---
```

- **Auto-Persona**: Frontend, Backend, Architect, Scribe
- **MCP Integration**: Magic (UI builds), Context7 (patterns), Sequential (logic)
- **Tool Orchestration**: [Read, Grep, Glob, Bash, TodoWrite, Edit, MultiEdit]
- **Arguments**: `[target]`, `@<path>`, `!<command>`, `--<flags>`

**`/sc:implement $ARGUMENTS`**

```yaml
---
command: "/sc:implement"
category: "Development & Implementation"
purpose: "Feature and code implementation with intelligent persona activation"
wave-enabled: true
performance-profile: "standard"
---
```

- **Auto-Persona**: Frontend, Backend, Architect, Security (context-dependent)
- **MCP Integration**: Magic (UI components), Context7 (patterns), Sequential (complex logic)
- **Tool Orchestration**: [Read, Write, Edit, MultiEdit, Bash, Glob, TodoWrite, Task]
- **Arguments**: `[feature-description]`, `--type component|api|service|feature`, `--framework <name>`, `--<flags>`

### Analysis Commands

**`/sc:analyze $ARGUMENTS`**

```yaml
---
command: "/sc:analyze"
category: "Analysis & Investigation"
purpose: "Multi-dimensional code and system analysis"
wave-enabled: true
performance-profile: "complex"
---
```

- **Auto-Persona**: Analyzer, Architect, Security
- **MCP Integration**: Sequential (primary), Context7 (patterns), Magic (UI analysis)
- **Tool Orchestration**: [Read, Grep, Glob, Bash, TodoWrite]
- **Arguments**: `[target]`, `@<path>`, `!<command>`, `--<flags>`

**`/sc:troubleshoot [symptoms] [flags]`** - Problem investigation | Auto-Persona: Analyzer, QA | MCP: Sequential,
Playwright

**`/sc:explain [topic] [flags]`** - Educational explanations | Auto-Persona: Mentor, Scribe | MCP: Context7, Sequential

### Quality Commands

**`/sc:improve [target] [flags]`**

```yaml
---
command: "/sc:improve"
category: "Quality & Enhancement"
purpose: "Evidence-based code enhancement"
wave-enabled: true
performance-profile: "optimization"
---
```

- **Auto-Persona**: Refactorer, Performance, Architect, QA
- **MCP Integration**: Sequential (logic), Context7 (patterns), Magic (UI improvements)
- **Tool Orchestration**: [Read, Grep, Glob, Edit, MultiEdit, Bash]
- **Arguments**: `[target]`, `@<path>`, `!<command>`, `--<flags>`

### Additional Commands

**`/spec:status <feature-name>`** - Show current spec status | Auto-Persona: Scribe, Mentor | MCP: Context7, Sequential

**`/spec:list`** - List all specs | Auto-Persona: Scribe, Mentor | MCP: Context7, Sequential

**`/sc:document [target] [flags]`** - Documentation generation | Auto-Persona: Scribe, Mentor | MCP: Context7,
Sequential

**`/sc:estimate [target] [flags]`** - Evidence-based estimation | Auto-Persona: Analyzer, Architect | MCP: Sequential,
Context7

**`/sc:task [operation] [flags]`** - Long-term project management | Auto-Persona: Architect, Analyzer | MCP: Sequential

**`/sc:test [type] [flags]`** - Testing workflows | Auto-Persona: QA | MCP: Playwright, Sequential

**`/sc:git [operation] [flags]`** - Git workflow assistant | Auto-Persona: DevOps, Scribe, QA | MCP: Sequential

**`/sc:design [domain] [flags]`** - Design orchestration | Auto-Persona: Architect, Frontend | MCP: Magic, Sequential,
Context7

**`/sc:cleanup [target] [flags]`** - Project cleanup and technical debt reduction | Auto-Persona: Refactorer | MCP:
Sequential

### Meta & Orchestration Commands

**`/sc:index [query] [flags]`** - Command catalog browsing | Auto-Persona: Mentor, Analyzer | MCP: Sequential

**`/sc:load [path] [flags]`** - Project context loading | Auto-Persona: Analyzer, Architect, Scribe | MCP: All servers

**`/sc:spawn [mode] [flags]`** - Task orchestration | Auto-Persona: Analyzer, Architect, DevOps | MCP: All servers

**Iterative Operations** - Use `--loop` flag with improvement commands for iterative refinement

## Command Execution Matrix

### Performance Profiles

```yaml
optimization: "High-performance with caching and parallel execution"
standard: "Balanced performance with moderate resource usage"
complex: "Resource-intensive with comprehensive analysis"
```

### Command Categories

- **Development**: spec:design, spec:tasks, spec:execute, build, implement, design
- **Planning**: spec-create, spec:requirements, estimate, task
- **Analysis**: analyze, troubleshoot, explain
- **Quality**: improve, cleanup
- **Testing**: test
- **Documentation**: document
- **Version-Control**: git
- **Meta**: index, load, spawn
