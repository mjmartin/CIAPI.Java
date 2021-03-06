package CIAPI.Java.core;

import java.util.concurrent.Future;

import JsonClient.Java.ApiException;
import JsonClient.Java.JsonApi;
import JsonClient.Java.async.AsyncJsonApi;
import JsonClient.Java.async.CallBack;

import CIAPI.Java.core.dto.*;

/**
 * Auto-generated interface for interacting with the REST CIAPI
 * 
 */
public interface ServiceMethods {

	<@@methods@@>
	/**
	 * !This is an auto generated method signature!
	 *
	 * <@description@>
	 *
	 * <@@parameterDescriptions@@>
	 * @param <@paramName@> <@paramDesc@><@@@@>
	 * @param api The JsonApi implementation that you would like.
	 */
	public <@return@> <@name@>(<@@parameters:,@@><@pType@> <@pName@><@@@@>, JsonApi api) throws ApiException; 
	
	/**
	 * !This is an auto generated method signature!
	 *
	 * <@description@>
	 *
	 * <@@parameterDescriptions@@>
	 * @param <@paramName@> <@paramDesc@><@@@@>
	 * @param api The AsyncJsonApi implementation that you would like.
	 */
	public Future<Object> <@name@>Async(<@@parameters:,@@><@pType@> <@pName@><@@@@>, AsyncJsonApi api, CallBack... callBacks) throws ApiException; <@@@@>
}
