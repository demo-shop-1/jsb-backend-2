package demo.jsb2.http;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AppHttpServletRequest extends HttpServletRequestWrapper {

    private final Map<String, String[]> customParams = new HashMap<>();

    public AppHttpServletRequest(HttpServletRequest request) {
        super(request);
        // copy the original parametersF
        customParams.putAll(request.getParameterMap());
    }

    public void setParameter(String name, String value) {
        customParams.put(name, new String[] { value });
    }

    @Override
    public String getParameter(String name) {
        String[] values = customParams.get(name);
        return (values != null && values.length > 0) ? values[0] : null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return customParams;
    }

    @Override
    public String[] getParameterValues(String name) {
        return customParams.get(name);
    }

}
