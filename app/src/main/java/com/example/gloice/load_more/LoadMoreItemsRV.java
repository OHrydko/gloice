package com.example.gloice.load_more;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LoadMoreItemsRV {

    private LoadMoreCallback loadMore;

    private int lastVisibleItem;
    private int totalItemCount;
    private int oldItemTotalCount;
    private int visibleThreshold;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private boolean isGridManager = false;

    public LoadMoreItemsRV(int visibleThreshold) {
        this.visibleThreshold = visibleThreshold;

    }

    public void setView(RecyclerView recyclerView) {

        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            isGridManager = true;
        } else if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            isGridManager = false;
        }

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (linearLayoutManager != null && !isGridManager) {
                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                } else if (gridLayoutManager != null && isGridManager) {
                    totalItemCount = gridLayoutManager.getItemCount();
                    lastVisibleItem = gridLayoutManager.findLastVisibleItemPosition();
                }
                boolean isItemAdded = totalItemCount != oldItemTotalCount;

                if (isItemAdded && totalItemCount <= (lastVisibleItem + visibleThreshold)) {

                    oldItemTotalCount = totalItemCount;

                    if (loadMore != null) {
                        loadMore.loadMore();
                    }

                }
            }
        });
    }


    public void setLoadMore(LoadMoreCallback loadMore) {
        this.loadMore = loadMore;
    }
}
