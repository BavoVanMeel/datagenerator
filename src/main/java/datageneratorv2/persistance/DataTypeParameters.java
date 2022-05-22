package datageneratorv2.persistance;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "dataTypeName")
@JsonSubTypes({ 
	@JsonSubTypes.Type(name = "ID", value = IDParameters.class),
	@JsonSubTypes.Type(name = "String", value = StringParameters.class),
	@JsonSubTypes.Type(name = "Integer", value = IntegerParameters.class) 
})
public abstract class DataTypeParameters {
	
}
