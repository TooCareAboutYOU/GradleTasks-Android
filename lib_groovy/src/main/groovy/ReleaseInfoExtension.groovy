class ReleaseInfoExtension {
    String versionCode
    String versionName
    String versionInfo
    String fileName


    @Override
    public String toString() {
        return "{" +
                "versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", versionInfo='" + versionInfo + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}