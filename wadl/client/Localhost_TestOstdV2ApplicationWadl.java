
package client;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.uri.UriTemplate;

@Generated(value = {
    "wadl|file:/C:/Java/IdeaProjects/TestOstd/DISTRIB.no-jersey/wadl/rest.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2016-03-21T00:09:09.110+02:00")
public class Localhost_TestOstdV2ApplicationWadl {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("http://localhost:8080/TestOstd/v2/application.wadl");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Localhost_TestOstdV2ApplicationWadl.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is!=null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
                    "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI +"']/@uri", 
                    new org.xml.sax.InputSource(is)); 
                if (found!=null && found.length()>0) {
                    originalURI = java.net.URI.create(found);
                }
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    public static Localhost_TestOstdV2ApplicationWadl.Root root(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Localhost_TestOstdV2ApplicationWadl.Root(client, baseURI);
    }

    /**
     * Template method to allow tooling to customize the new Client
     * 
     */
    private static void customizeClientConfiguration(ClientConfig cc) {
    }

    /**
     * Template method to allow tooling to override Client factory
     * 
     */
    private static com.sun.jersey.api.client.Client createClientInstance(ClientConfig cc) {
        return com.sun.jersey.api.client.Client.create(cc);
    }

    /**
     * Create a new Client instance
     * 
     */
    public static com.sun.jersey.api.client.Client createClient() {
        ClientConfig cc = new DefaultClientConfig();
        customizeClientConfiguration(cc);
        return createClientInstance(cc);
    }

    public static Localhost_TestOstdV2ApplicationWadl.Root root() {
        return root(createClient(), BASE_URI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.Root root(com.sun.jersey.api.client.Client client) {
        return root(client, BASE_URI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.V2ApplicationWadl v2ApplicationWadl(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Localhost_TestOstdV2ApplicationWadl.V2ApplicationWadl(client, baseURI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.V2ApplicationWadl v2ApplicationWadl() {
        return v2ApplicationWadl(createClient(), BASE_URI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.V2ApplicationWadl v2ApplicationWadl(com.sun.jersey.api.client.Client client) {
        return v2ApplicationWadl(client, BASE_URI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAccIban restAccIban(com.sun.jersey.api.client.Client client, URI baseURI, String iban) {
        return new Localhost_TestOstdV2ApplicationWadl.RestAccIban(client, baseURI, iban);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAccIban restAccIban(String iban) {
        return restAccIban(createClient(), BASE_URI, iban);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAccIban restAccIban(com.sun.jersey.api.client.Client client, String iban) {
        return restAccIban(client, BASE_URI, iban);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAcc restAcc(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Localhost_TestOstdV2ApplicationWadl.RestAcc(client, baseURI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAcc restAcc() {
        return restAcc(createClient(), BASE_URI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAcc restAcc(com.sun.jersey.api.client.Client client) {
        return restAcc(client, BASE_URI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAccList restAccList(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Localhost_TestOstdV2ApplicationWadl.RestAccList(client, baseURI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAccList restAccList() {
        return restAccList(createClient(), BASE_URI);
    }

    public static Localhost_TestOstdV2ApplicationWadl.RestAccList restAccList(com.sun.jersey.api.client.Client client) {
        return restAccList(client, BASE_URI);
    }

    public static class RestAcc {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private RestAcc(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public RestAcc(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/rest/acc");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        /**
         * AccountController.getAll.
         * 
         */
        public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        /**
         * AccountController.getAll.
         * 
         */
        public<T >T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        /**
         * AccountController.updateOrCreate.
         * 
         */
        public com.sun.jersey.api.client.ClientResponse postAsClientResponse() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
        }

        /**
         * AccountController.updateOrCreate.
         * 
         */
        public<T >T post(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        /**
         * AccountController.updateOrCreate.
         * 
         */
        public<T >T post(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

    }

    public static class RestAccIban {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private RestAccIban(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public RestAccIban(com.sun.jersey.api.client.Client client, URI baseUri, String iban) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/rest/acc/{iban}");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
            _templateAndMatrixParameterValues.put("iban", iban);
        }

        /**
         * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
         * 
         */
        public RestAccIban(com.sun.jersey.api.client.Client client, URI uri) {
            _client = client;
            StringBuilder template = new StringBuilder(BASE_URI.toString());
            if (template.charAt((template.length()- 1))!= '/') {
                template.append("/rest/acc/{iban}");
            } else {
                template.append("rest/acc/{iban}");
            }
            _uriBuilder = UriBuilder.fromPath(template.toString());
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
            UriTemplate uriTemplate = new UriTemplate(template.toString());
            HashMap<String, String> parameters = new HashMap<String, String>();
            uriTemplate.match(uri.toString(), parameters);
            _templateAndMatrixParameterValues.putAll(parameters);
        }

        /**
         * Get iban
         * 
         */
        public String getIban() {
            return ((String) _templateAndMatrixParameterValues.get("iban"));
        }

        /**
         * Duplicate state and set iban
         * 
         */
        public Localhost_TestOstdV2ApplicationWadl.RestAccIban setIban(String iban) {
            Map<String, Object> copyMap;
            copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
            UriBuilder copyUriBuilder = _uriBuilder.clone();
            copyMap.put("iban", iban);
            return new Localhost_TestOstdV2ApplicationWadl.RestAccIban(_client, copyUriBuilder, copyMap);
        }

        /**
         * AccountController.get.
         * 
         */
        public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        /**
         * AccountController.get.
         * 
         */
        public<T >T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        /**
         * AccountController.delete.
         * 
         */
        public com.sun.jersey.api.client.ClientResponse deleteAsClientResponse() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
        }

        /**
         * AccountController.delete.
         * 
         */
        public<T >T delete(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        /**
         * AccountController.delete.
         * 
         */
        public<T >T delete(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

    }

    public static class RestAccList {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private RestAccList(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public RestAccList(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/rest/acc/list");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        /**
         * AccountController.getList.
         * 
         */
        public com.sun.jersey.api.client.ClientResponse postAsClientResponse() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
        }

        /**
         * AccountController.getList.
         * 
         */
        public<T >T post(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        /**
         * AccountController.getList.
         * 
         */
        public<T >T post(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

    }

    public static class Root {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Root(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Root(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        /**
         * RootController.root.
         * 
         */
        public com.sun.jersey.api.client.ClientResponse getAsClientResponse() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(com.sun.jersey.api.client.ClientResponse.class);
        }

        /**
         * RootController.root.
         * 
         */
        public<T >T get(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        /**
         * RootController.root.
         * 
         */
        public<T >T get(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

    }

    public static class V2ApplicationWadl {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private V2ApplicationWadl(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public V2ApplicationWadl(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/v2/application.wadl");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        /**
         * WADLControllerV2.generateWadl.
         * 
         */
        public<T >T getAsXml(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        /**
         * WADLControllerV2.generateWadl.
         * 
         */
        public<T >T getAsXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_TestOstdV2ApplicationWadl.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

    }


    /**
     * Workaround for JAX_RS_SPEC-312
     * 
     */
    private static class WebApplicationExceptionMessage
        extends WebApplicationException
    {


        private WebApplicationExceptionMessage(Response response) {
            super(response);
        }

        /**
         * Workaround for JAX_RS_SPEC-312
         * 
         */
        public String getMessage() {
            Response response = getResponse();
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            if (status!= null) {
                return (response.getStatus()+(" "+ status.getReasonPhrase()));
            } else {
                return Integer.toString(response.getStatus());
            }
        }

        public String toString() {
            String s = "javax.ws.rs.WebApplicationException";
            String message = getLocalizedMessage();
            return (s +(": "+ message));
        }

    }

}
