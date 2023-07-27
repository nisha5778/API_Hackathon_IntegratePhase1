package api.payload;

public class UserRole {
//	Can't create, edit, or upload … Not enough storage. Get more now, or remove files from Drive, Google Photos, or Gmail.
		
		private String roleId;
		private String userRoleStatus;
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
		public String getUserRoleStatus() {
			return userRoleStatus;
		}
		public void setUserRoleStatus(String userRoleStatus) {
			this.userRoleStatus = userRoleStatus;
		}
		
		
}
