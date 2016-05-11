package com.chalmie.anovelsharingapp.util;

/**
 * Created by chalmie on 5/11/16.
 */
public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
