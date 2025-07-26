package io.openads.adsmanager.adaccount.domain.vo

enum class MemberRole {
    OWNER,
    ADMIN,
    EDITOR,
    VIEWER;

    fun canManageMembers(): Boolean = this in setOf(OWNER, ADMIN)
    fun canEditCampaigns(): Boolean = this in setOf(OWNER, ADMIN, EDITOR)
    fun canViewReports(): Boolean = true // All roles can view
}