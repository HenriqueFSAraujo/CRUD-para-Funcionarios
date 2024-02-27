package br.gov.prodemge.proddigio.meucurso.controle;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@Provider
public class MeucursoBaseJsonProvider extends JacksonJsonProvider {

//	@Override
//	public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
//		 ObjectMapper mapper = locateMapper(type, mediaType);
//		 mapper.setSerializationInclusion(Inclusion.NON_NULL);
//		 mapper.configure(Feature.USE_ANNOTATIONS, true);
//		
//		super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, entityStream);
//	} 
}
