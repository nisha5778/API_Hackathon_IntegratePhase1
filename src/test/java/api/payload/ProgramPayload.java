package api.payload;

public class ProgramPayload {	
	CreationTime creationTime;
	LastModTime lastModTime;
	String programDescription;
	int programId;
	String programName;
	String programStatus;
	
	public CreationTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(CreationTime creationTime) {
		this.creationTime = creationTime;
	}
	public LastModTime getLastModTime() {
		return lastModTime;
	}
	public void setLastModTime(LastModTime lastModTime) {
		this.lastModTime = lastModTime;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramStatus() {
		return programStatus;
	}
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	
}
