package codegen.codetemplates.templatecompletion.replacementrule;

import java.util.List;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.CompoundCodeTemplate;

/**
 * Represents a replacement set from the XML
 * 
 * @author Justin Nelson
 * 
 */
public class ReplacementSet extends Replacement {

	private String subObjName;
	private List<Replacement> subPlacemnets;
	private String deilm;

	/**
	 * Creates a new replacement set with the given arguments
	 * 
	 * @param templateValue
	 *            the template name to replace with this replacement set
	 * @param objectValue
	 *            the path to retrieve the sub object
	 * @param objName
	 *            the name used to refer to the object
	 * @param subObjName
	 *            the name used to refer to the sub object
	 * @param subPlacements
	 *            the replacements to perform on the sub object
	 * @param delim
	 *            the delimiter to use to separate subsequent replacements
	 */
	public ReplacementSet(String templateValue, String objectValue, String objName,
			String subObjName, List<Replacement> subPlacements, String delim) {
		super(templateValue, objectValue, objName);
		this.subObjName = subObjName;
		this.subPlacemnets = subPlacements;
		this.deilm = delim;
		if (this.deilm == null)
			this.deilm = "";
	}

	@Override
	public String getTemplateName() {
		return templateValue;
	}

	@Override
	public void fillTemplateHole(Object obj, CodeTemplate template, String... args) {
		Iterable<?> result = (Iterable<?>) resolveValue(obj, args);
		if (result == null) {
			return;
		}
		CompoundCodeTemplate comp = (CompoundCodeTemplate) template.getTemplateEntry(templateValue);
		CodeTemplate toFill = comp.getEmptyTemplate();
		for (Object o : result) {
			fillSubTemplate(o, toFill, comp, args);
		}
	}

	protected void fillSubTemplate(Object subObj, CodeTemplate subTemplateToFill,
			CompoundCodeTemplate masterTemplate, String... args) {
		CodeTemplate clone = subTemplateToFill.copyEmptyTemplate();
		for (Replacement r : subPlacemnets) {
			r.fillTemplateHole(subObj, clone, args);
		}
		masterTemplate.addMappingSet(clone);
	}
}