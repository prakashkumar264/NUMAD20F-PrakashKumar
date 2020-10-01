package edu.neu.madcourse.numad20f_prakashkumar;

public class link_card {
    private String _urlName;
    private String _urlLink;

    public link_card(String urlName, String urlLink) {
        this._urlName = urlName;
        this._urlLink = urlLink;
    }

    public String get_urlLink() {
        return _urlLink;
    }

    public String get_urlName() {
        return _urlName;
    }
}
