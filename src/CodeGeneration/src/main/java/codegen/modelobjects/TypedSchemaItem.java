package codegen.modelobjects;

/**
 * Abstract class representing any SMD or Schema type that can be 'typed'
 * 
 * @author Justin Nelson
 * 
 */
public abstract class TypedSchemaItem {
	protected Type type;
	protected Items items;
	protected String description;

	/**
	 * Given a package name, will return the fully qualified type name
	 * 
	 * @param packageName
	 *            the package this type belongs to
	 * @return the fully qualified type name.
	 */
	public String getType(String packageName) {
		return type.toString();
	}

	public String getType(){
		return getType("");
	}
	
	public String getDescription() {
		return description;
	}
}
