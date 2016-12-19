package com.luke.makename.util;

import com.luke.makename.gossip.Gossip;

/**
 * Created by LukeSkywalker on 2016/12/19.
 */
public class GossipUtil {
    public static boolean isGoodGossip(int surnameStork, int nameStork) {
        return new Gossip(surnameStork, nameStork).isGoodGossip();
    }
}
