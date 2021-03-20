package com.thrillio.entities;

import com.thrillio.partner.Shareable;

public class WebLink extends Bookmark implements Shareable {

    private String url;
    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WebLink{" +
                "url='" + url + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    @Override
    public boolean IsKidFriendlyEligible() {
        if(url.contains("porn") || getTitle().contains("porn")){
            return false;
        }
        return true;
    }

    @Override

    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
            builder.append("<title>");
                builder.append("<type>WebLink</type>");
                builder.append("<url>").append(url).append("</url>");
                builder.append("<host>").append(host).append("</host>");

        builder.append("</item>");

        return builder.toString();

    }
}


