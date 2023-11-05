package com.servlet.view.toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.servlet.app.model.view.MenuLink;
import com.servlet.app.model.view.MenuLinkStatus;

public class TopBar implements Menu, Serializable {
    private final List<MenuLink> links = new ArrayList<>();
    // initializer block
    {
        links.add(new MenuLink("./approvals", "Approval Status", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./profile", "Profile", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./produce", "Products", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./sell", "Sell", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./buy", "Buy", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./reports", "Buy", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./track", "Track my Produce", MenuLinkStatus.NOT_ACTIVE));

    }

    @Override
    public String menu(int activeLinkIndex) {
        this.activateLink(activeLinkIndex);

        String menuBar = "<nav class=\"navContainer\">\n" +
                "    <div class=\"logoName\">\n" +
                "        <span class=\"logo_name\">Ukulima Bora</span>\n" +
                "    </div>\n" +
                "    <form method=\"post\">\n" +
                "    <div class=\"menu-items\">\n" +
                "        <ul class=\"nav-links\">\n";

        for (MenuLink link : links) {
            menuBar += "            <li><a href=\"" + link.getUrl() + "\">\n" +
                    "            <img src=\"icons/home.jpg\" class=\"icon\"/>\n" +
                    "                <span class=\"link-name\">" + link.getLabel() + "</span>\n" +
                    "            </a></li>\n";
        }
        menuBar += "        </ul>\n" +
                "        <ul>\n" +
                "            <li><a href=\"./logout\">\n" +
                "            <img src=\"icons/signout.jpg\" class=\"icon\" />\n" +
                "                <span class=\"link-name\">Log out</span>\n" +
                "            </a></li>\n" +
                "        </ul>\n" +
                "    </div>\n" +
                "    </form>\n" +
                "</nav>";
        return menuBar;
    }

    private void activateLink(int activeLinkIndex) {
        for (int index = 0; index < links.size(); index++) {
            if (index == activeLinkIndex)
                links.get(index).setMenuLinkStatus(MenuLinkStatus.ACTIVE);
            else
                links.get(index).setMenuLinkStatus(MenuLinkStatus.NOT_ACTIVE);
        }
    }

}
