package talend.ext.images.server.backup;

public class ResourcePK {
	
	private String catalogName;
	
	private String fileName;

	public ResourcePK(String catalogName, String fileName) {
		super();
		this.catalogName = catalogName;
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		if(catalogName==null||catalogName.equals("")){
			return fileName;
		}else{
			return catalogName+"-"+fileName;
		}
		
	}

}
