package com.cziyeli.retrofitsample.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cziyeli.retrofitsample.R;
import com.cziyeli.retrofitsample.models.GitRepo;

import java.util.List;
/**
 * Adapter setting GitRepo[] array to RecyclerView + CardView.
 */
public class GitReposAdapter extends RecyclerView.Adapter<GitReposAdapter.RepoViewHolder> {
	List<GitRepo> mRepos;

	public GitReposAdapter(List<GitRepo> repos) {
		mRepos = repos;
	}

	public void updateRepos(List<GitRepo> repos) {
		mRepos = repos;
		notifyDataSetChanged();
	}

	@Override
	public RepoViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
		final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.github_repo_item, parent, false);
		RepoViewHolder viewholder = new RepoViewHolder(v);

		return viewholder;
	}

	@Override
	public void onBindViewHolder(RepoViewHolder holder, int position) {
		final GitRepo repo = mRepos.get(position);
		holder.repoName.setText(repo.getName());
		holder.repoDescription.setText(repo.getDescription());
		// set avatar
		Log.d("connie", "onBindViewHolder avatar url: " + repo.getOwner().getAvatarUrl());
	}

	@Override
	public int getItemCount() {
		return mRepos.size();
	}

	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		super.onAttachedToRecyclerView(recyclerView);
	}

	public static class RepoViewHolder extends RecyclerView.ViewHolder {
		CardView cardView;
		TextView repoName;
		TextView repoDescription;
		ImageView repoAvatar;

		public RepoViewHolder(View itemView) {
			super(itemView);
			cardView = (CardView) itemView.findViewById(R.id.repo_card);
			repoName = (TextView) itemView.findViewById(R.id.repo_name);
			repoDescription = (TextView) itemView.findViewById(R.id.repo_description);
			repoAvatar = (ImageView) itemView.findViewById(R.id.repo_user_avatar);
		}
	}
}
