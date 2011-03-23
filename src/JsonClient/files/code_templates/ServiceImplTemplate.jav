package <@packageName@>.impl;

import CIAPI.Java.ApiException;
import CIAPI.Java.JsonApi;
import <@packageName@>.ServiceMethods;

public class ServiceMethodsImpl implements ServiceMethods {

	private JsonApi api = new JsonApi("someBaseUrl", null);

	<@@methods@@>
	/**
	 * !This is an auto generated method!
	 *
	 * <@description@>
	 */
	@Override
	public <@return@> <@name@>(<@parameters@>) throws ApiException {
		// Collect variables from method
		String target = "<@target@>";
		String uriTemplate = "<@uriTemplate@>";
		String transport = "<@transport@>";
		String envelope = "<@envelope@>";
		String contentType = "<@contentType@>";
		String filledUri = uriTemplate;
		// Done collecting variables
		// Fill in necessary holes in the URL.
		<@@fillParameters@@>
		filledUri = filledUri.replace("{<@parameterName@>}", <@parameterName@> + "");<@@@@>
		// Done filling in holes
		// build final URL
		String fullUrl = target + filledUri;
		// done building final url
		// return type result type get/post url params return type.class
		<@return@> result = (<@return@>) api.callGetMethod(fullUrl, <@return@>.class);
		return result;
	}<@@@@>
}
