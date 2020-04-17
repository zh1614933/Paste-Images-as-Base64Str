package org.herry.pic.dto;

/**
 * @author zhangheng
 * @date 2020/4/6 23:06
 */
public class GitDto {
    /**
     * 定义本地git路径
     */
    protected String localPath;

    /**
     *     .git文件路径  localPath + ".git"
     */
    protected String localGitFile;

    /**
     * 远程仓库地址
     */
    protected String remoteRepoUri;

    /**
     * 用户名
     */
    protected String userName;

    /**
     * 用户邮箱
     */
    protected String email;

    /**
     * 用户密码
     */
    protected String password;

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getLocalGitFile() {
        return localGitFile;
    }

    public void setLocalGitFile(String localGitFile) {
        this.localGitFile = localGitFile;
    }

    public String getRemoteRepoUri() {
        return remoteRepoUri;
    }

    public void setRemoteRepoUri(String remoteRepoUri) {
        this.remoteRepoUri = remoteRepoUri;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "GitDto{" +
                "localPath='" + localPath + '\'' +
                ", localGitFile='" + localGitFile + '\'' +
                ", remoteRepoUri='" + remoteRepoUri + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
