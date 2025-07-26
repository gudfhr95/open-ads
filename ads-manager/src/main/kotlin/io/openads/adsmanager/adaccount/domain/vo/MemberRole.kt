package io.openads.adsmanager.adaccount.domain.vo

enum class MemberRole {
    OWNER,
    ADMIN,
    EDITOR,
    VIEWER;

    fun canManageMembers(): Boolean = when (this) {
        OWNER, ADMIN -> true
        EDITOR, VIEWER -> false
    }

    fun canEditCampaigns(): Boolean = when (this) {
        OWNER, ADMIN, EDITOR -> true
        VIEWER -> false
    }

    fun canViewReports(): Boolean = true
}