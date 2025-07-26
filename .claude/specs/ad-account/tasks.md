# Ad-Account Management Implementation Plan

## Task Overview

Implement the Ad-Account Management System by extending the existing `adaccount` module infrastructure. The implementation will leverage existing patterns including domain-driven design, event sourcing with Spring Modulith, and the established testing framework. Tasks are structured to maximize code reuse from existing components like `BaseEntity`, `UpdatableEntity`, authentication mechanisms, and the mail system.

## Tasks

1. Set up database schema and migrations
    - Create MySQL migration scripts for `ad_accounts`, `ad_account_members`, `ad_account_budgets`, and `ad_account_audit_logs` tables
    - Configure Spring Data JDBC auditing for created/updated tracking
    - Add database indexes for performance optimization
    - _Leverage: existing database configuration and migration patterns_
    - _Requirements: All requirements need persistence_

2. Implement domain value objects

   2.1. Create AdAccountId value object
    - Implement as Kotlin inline value class following AdUserId pattern
    - Add validation for UUID format
    - Write unit tests for validation
    - _Leverage: src/main/kotlin/io/openads/adsmanager/adaccount/domain/vo/AdUserId.kt_
    - _Requirements: 1.1, 1.2_

   2.2. Create enums for MemberRole, AccountStatus, and BudgetType
    - Define MemberRole enum with permission methods (canManageMembers, canEditCampaigns)
    - Define AccountStatus enum with operational state checks
    - Define BudgetType enum (DAILY, LIFETIME)
    - Write unit tests for enum behaviors
    - _Requirements: 2.2, 3.1, 4.1_

3. Implement domain entities

   3.1. Create AdAccount entity
    - Extend UpdatableEntity for audit tracking
    - Implement factory method for account creation with PENDING_VERIFICATION status
    - Add business validation rules (name length, billing info)
    - Implement status update methods
    - Write unit tests using Kotest FunSpec
    - _Leverage: src/main/kotlin/io/openads/adsmanager/shared/domain/entity/UpdatableEntity.kt_
    - _Requirements: 1.1, 1.2, 1.3, 3.1, 3.2_

   3.2. Create AdAccountMember entity
    - Extend BaseEntity for audit tracking
    - Implement invitation and acceptance logic
    - Add role update methods
    - Write unit tests for member lifecycle
    - _Leverage: src/main/kotlin/io/openads/adsmanager/shared/domain/entity/BaseEntity.kt_
    - _Requirements: 2.1, 2.2, 2.3, 2.4, 2.5_

   3.3. Create AdAccountBudget entity
    - Extend UpdatableEntity for change tracking
    - Implement budget validation and calculation logic
    - Add currency support and date range validation
    - Write unit tests for budget operations
    - _Leverage: src/main/kotlin/io/openads/adsmanager/shared/domain/entity/UpdatableEntity.kt_
    - _Requirements: 4.1, 4.2, 4.3, 4.4, 4.5_

4. Implement repository interfaces and Spring Data JDBC repositories

   4.1. Create repository interfaces
    - Define AdAccountRepository with custom query methods
    - Define AdAccountMemberRepository with membership queries
    - Define AdAccountBudgetRepository with budget queries
    - Follow Spring Data JDBC CrudRepository pattern
    - _Leverage: src/main/kotlin/io/openads/adsmanager/adaccount/domain/repository/AdUserRepository.kt_
    - _Requirements: All - repositories needed for all operations_

   4.2. Implement audit log repository
    - Create AdAccountAuditLogRepository
    - Add methods for querying by account, user, and date range
    - Implement retention period queries
    - _Requirements: 6.1, 6.2, 6.4, 6.5_

5. Implement domain events

   5.1. Create account lifecycle events
    - Implement AdAccountCreatedV1 with @Externalized annotation
    - Implement AdAccountStatusChangedV1 for status transitions
    - Configure Spring Modulith event routing
    - Write unit tests for event creation
    - _Leverage: src/main/kotlin/io/openads/adsmanager/adaccount/domain/event/AdUserCreatedV1.kt_
    - _Requirements: 1.4, 3.6_

   5.2. Create member and budget events
    - Implement MemberAddedV1, MemberRoleChangedV1, MemberRemovedV1
    - Implement BudgetUpdatedV1 for budget changes
    - Add event serialization tests
    - _Leverage: existing @Externalized event patterns_
    - _Requirements: 2.5, 4.5_

6. Implement domain services

   6.1. Create CreateAdAccountService
    - Implement account creation with owner assignment
    - Add account limit validation (max 10 active accounts)
    - Publish AdAccountCreatedV1 event using ApplicationEventPublisher
    - Write unit tests with mockk
    - _Leverage: src/main/kotlin/io/openads/adsmanager/adaccount/domain/service/CreateAdUserService.kt_
    - _Requirements: 1.1, 1.2, 1.3, 1.4_

   6.2. Create member management services
    - Implement AddAccountMemberService with invitation logic
    - Implement RemoveAccountMemberService with access revocation
    - Implement UpdateMemberRoleService with permission checks
    - Publish appropriate events for each operation
    - _Leverage: existing service patterns and ApplicationEventPublisher_
    - _Requirements: 2.1, 2.2, 2.3, 2.4, 2.5, 2.6_

   6.3. Create account management services
    - Implement UpdateAccountStatusService with state transitions
    - Implement SetAccountBudgetService with validation
    - Add parent-child account handling for suspensions
    - _Requirements: 3.1, 3.2, 3.3, 3.4, 3.5, 4.1, 4.2, 5.4_

7. Implement use cases with transactional orchestration

   7.1. Create account management use cases
    - Implement CreateAdAccountUseCase with @Transactional and operator invoke
    - Implement GetAdAccountUseCase with permission checks
    - Implement UpdateAccountStatusUseCase with cascade logic
    - Write integration tests using IntegrationTestSpec
    - _Leverage: src/main/kotlin/io/openads/adsmanager/adaccount/usecase/aduser/CreateAdUserUseCase.kt_
    - _Requirements: 1.1, 1.5, 3.1, 3.2, 3.4, 5.1, 5.2, 5.3, 5.4_

   7.2. Create member management use cases
    - Implement AddAccountMemberUseCase with mail notification
    - Implement RemoveAccountMemberUseCase with immediate access revocation
    - Implement UpdateMemberRoleUseCase with authorization checks
    - Integrate with MailPort for invitations
    - _Leverage: src/main/kotlin/io/openads/adsmanager/adaccount/port/mail/MailPort.kt_
    - _Requirements: 2.1, 2.2, 2.3, 2.4, 2.5, 2.6_

   7.3. Create budget management use cases
    - Implement SetAccountBudgetUseCase with validation
    - Implement GetBudgetStatusUseCase with spending calculations
    - Add budget warning notification logic
    - _Requirements: 4.1, 4.2, 4.3, 4.4, 4.5_

8. Implement REST controllers and DTOs

   8.1. Create account management endpoints
    - Implement AdAccountControllerV1 with JWT authentication
    - Create AdAccountRequestV1 and AdAccountResponseV1 DTOs
    - Add OpenAPI documentation annotations
    - Write acceptance tests using AcceptanceTestSpec
    - _Leverage: src/main/kotlin/io/openads/adsmanager/adaccount/input/rest/v1/aduser/AdUserControllerV1.kt_
    - _Requirements: 1.1, 1.2, 1.5, 3.1, 3.2_

   8.2. Create member management endpoints
    - Implement MemberControllerV1 for member operations
    - Create member request/response DTOs with role validation
    - Add permission checks using JWT claims
    - _Leverage: existing REST controller patterns and JwtAuthenticationToken_
    - _Requirements: 2.1, 2.2, 2.3, 2.4, 2.6_

   8.3. Create budget management endpoints
    - Implement BudgetControllerV1 for budget operations
    - Create budget DTOs with currency and date validation
    - Add budget status endpoint with projections
    - _Requirements: 4.1, 4.2, 4.4_

9. Implement mail adapter for member invitations

   9.1. Create MemberInvitationMailAdapter
    - Implement MailPort interface for sending invitations
    - Create invitation email templates
    - Add invitation link generation logic
    - Write unit tests for mail formatting
    - _Leverage: src/main/kotlin/io/openads/adsmanager/adaccount/output/mail/MailAdapter.kt_
    - _Requirements: 2.1_

10. Implement exception handling and validation

    10.1. Create domain exceptions
     - Implement AccountNotFoundException, AccountLimitExceededException
     - Implement UnauthorizedAccountAccessException, InsufficientPermissionException
     - Implement DuplicateMemberException
     - Create global exception handler for REST responses
     - _Leverage: existing exception handling patterns_
     - _Requirements: 1.3, 2.3, 2.6, 3.3_

    10.2. Add input validation
     - Implement DTO validation with Bean Validation annotations
     - Add custom validators for business rules
     - Create validation error response formatting
     - _Requirements: All - validation needed throughout_

11. Implement audit logging functionality

    11.1. Create audit logging service
     - Implement audit log creation for all state changes
     - Add user attribution from security context
     - Implement log retention and archival logic
     - _Requirements: 6.1, 6.2, 6.3, 6.4, 6.5_

    11.2. Create audit query endpoints
     - Implement audit log query API with pagination
     - Add CSV/JSON export functionality
     - Apply 90-day default query window
     - _Requirements: 6.2, 6.4_

12. Performance optimization and caching

    12.1. Implement caching layer
     - Configure Redis for account metadata caching
     - Add cache eviction on updates
     - Implement cache warming strategies
     - _Leverage: existing caching configuration_
     - _Requirements: NFR - Performance_

    12.2. Add monitoring and metrics
     - Implement operation timing metrics
     - Add circuit breakers for external dependencies
     - Configure rate limiting on API endpoints
     - _Requirements: NFR - Performance, Security, Availability_

13. Comprehensive testing implementation

    13.1. Write integration tests
     - Create integration tests for complete workflows
     - Test event publishing and handling
     - Verify database state after operations
     - _Leverage: src/test/kotlin/io/openads/adsmanager/test/spec/IntegrationTestSpec.kt_
     - _Requirements: All features need integration testing_

    13.2. Write end-to-end acceptance tests
     - Implement full user journey tests
     - Test API authentication and authorization
     - Verify response formats and status codes
     - _Leverage: src/test/kotlin/io/openads/adsmanager/test/spec/AcceptanceTestSpec.kt_
     - _Requirements: All API endpoints need acceptance testing_

    13.3. Performance and security testing
     - Implement performance benchmarks for critical operations
     - Add security tests for authorization scenarios
     - Test rate limiting and error scenarios
     - _Requirements: NFR - Performance, Security_

## Task Dependencies

- Tasks 1-5 can be done in parallel (infrastructure setup)
- Tasks 6-7 depend on tasks 2-5 (domain logic implementation)
- Tasks 8-9 depend on tasks 6-7 (API layer)
- Tasks 10-11 can be done in parallel with 8-9
- Task 12 depends on tasks 8-11 (optimization requires working system)
- Task 13 depends on all previous tasks (comprehensive testing)

## Definition of Done

Each task is considered complete when:
- Code is implemented following existing patterns
- Unit tests are written and passing
- Integration tests verify the functionality
- Code passes linting and formatting checks
- Changes are committed with proper messages
- Code is production-ready and deployable

Do the tasks look good?
