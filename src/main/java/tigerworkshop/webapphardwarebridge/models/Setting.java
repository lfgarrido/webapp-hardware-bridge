package tigerworkshop.webapphardwarebridge.models;

import java.util.HashMap;

@Deprecated
public class Setting {
    String address = "127.0.0.1";
    String bind = "0.0.0.0";
    int port = 12212;
    boolean fallbackToDefaultPrinter = false;
    boolean ignoreTLSCertificateError = false;
    boolean autoRotation = false;
    boolean resetImageableArea = true;
    int printerDPI = 0;
    Double downloadTimeout = 30.0;

    HashMap<String, Object> authentication = new HashMap<String, Object>() {{
        put("enabled", false);
        put("token", "");
    }};

    HashMap<String, Object> tls = new HashMap<String, Object>() {{
        put("enabled", false);
        put("selfSigned", true);
        put("cert", "tls/default-cert.pem");
        put("key", "tls/default-key.pem");
        put("caBundle", "");
    }};

    HashMap<String, Object> cloudProxy = new HashMap<String, Object>() {{
        put("enabled", false);
        put("url", "ws://127.0.0.1:22212");
        put("timeout", 30);
    }};

    HashMap<String, String> printers = new HashMap<>();
    HashMap<String, String> serials = new HashMap<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Boolean getFallbackToDefaultPrinter() {
        return fallbackToDefaultPrinter;
    }

    public void setFallbackToDefaultPrinter(boolean fallbackToDefaultPrinter) {
        this.fallbackToDefaultPrinter = fallbackToDefaultPrinter;
    }

    public Boolean getAuthenticationEnabled() {
        return (Boolean) authentication.get("enabled");
    }

    public void setAuthenticationEnabled(Boolean value) {
        authentication.put("enabled", value);
    }

    public Boolean getIgnoreTLSCertificateErrorEnabled() {
        return ignoreTLSCertificateError;
    }

    public void setIgnoreTLSCertificateErrorEnabled(Boolean value) {
        ignoreTLSCertificateError = value;
    }

    public String getAuthenticationToken() {
        return (String) authentication.get("token");
    }

    public void setAuthenticationToken(String value) {
        authentication.put("token", value);
    }

    public Boolean getTLSEnabled() {
        return (boolean) tls.get("enabled");
    }

    public void setTLSEnabled(Boolean value) {
        tls.put("enabled", value);
    }

    public Boolean getTLSSelfSigned() {
        return (Boolean) tls.get("selfSigned");
    }

    public void setTLSSelfSigned(Boolean value) {
        tls.put("selfSigned", value);
    }

    public String getTLSCert() {
        return (String) tls.get("cert");
    }

    public void setTLSCert(String value) {
        tls.put("cert", value);
    }

    public String getTLSKey() {
        return (String) tls.get("key");
    }

    public void setTLSKey(String value) {
        tls.put("key", value);
    }

    public String getTLSCaBundle() {
        return (String) tls.get("caBundle");
    }

    public void setTLSCaBundle(String value) {
        tls.put("caBundle", value);
    }

    public Double getCloudProxyTimeout() {
        return cloudProxy.containsKey("timeout") ? (Double) cloudProxy.get("timeout") : 30;
    }

    public void setCloudProxyTimeout(Double value) {
        this.cloudProxy.put("timeout", value);
    }

    public Boolean getCloudProxyEnabled() {
        return (boolean) cloudProxy.get("enabled");
    }

    public void setCloudProxyEnabled(Boolean value) {
        this.cloudProxy.put("enabled", value);
    }

    public String getCloudProxyUrl() {
        return (String) cloudProxy.get("url");
    }

    public void setCloudProxyUrl(String value) {
        this.cloudProxy.put("url", value);
    }

    public HashMap<String, String> getPrinters() {
        return printers;
    }

    public void setPrinters(HashMap<String, String> printers) {
        this.printers = printers;
    }

    public boolean getAutoRotation() {
        return autoRotation;
    }

    public void setAutoRotation(boolean autoRotation) {
        this.autoRotation = autoRotation;
    }

    public boolean getResetImageableArea() {
        return resetImageableArea;
    }

    public void setResetImageableArea(boolean resetImageableArea) {
        this.resetImageableArea = resetImageableArea;
    }

    public int getPrinterDPI() {
        return printerDPI;
    }

    public void setPrinterDPI(int printerDPI) {
        this.printerDPI = printerDPI;
    }

    public double getDownloadTimeout() {
        return downloadTimeout;
    }

    public void setDownloadTimeout(double downloadTimeout) {
        this.downloadTimeout = downloadTimeout;
    }

    public HashMap<String, String> getSerials() {
        return serials;
    }

    public void setSerials(HashMap<String, String> serials) {
        this.serials = serials;
    }

    public String getUri() {
        return (getTLSEnabled() ? "wss" : "ws") + "://" + getAddress() + ":" + getPort();
    }
}