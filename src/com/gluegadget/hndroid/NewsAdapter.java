package com.gluegadget.hndroid;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<News> {
	private LayoutInflater mInflater;
	int resource;
	
	public NewsAdapter(Context _context, int _resource, List<News> _items) {
		super(_context, _resource, _items);
		mInflater = (LayoutInflater)_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		resource = _resource;
	}
	
	static class ViewHolder {
		TextView title;
		TextView score;
		TextView author;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		
		News item = getItem(position);
		
		if (convertView == null) {
			convertView = mInflater.inflate(resource, parent, false);
			holder = new ViewHolder();
			holder.title = (TextView)convertView.findViewById(R.id.title);
			holder.score = (TextView)convertView.findViewById(R.id.score);
			holder.author = (TextView)convertView.findViewById(R.id.author);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		
		holder.title.setText(item.getTitle());
		holder.score.setText(item.getScore());

		if (item.getAuthor() == "")
			holder.author.setText(item.getAuthor());
		else
			if (item.getDomain() == "")
				holder.author.setText("by " + item.getAuthor());
			else
				holder.author.setText("by " + item.getAuthor() + " from " + item.getDomain());
		

		return convertView;
	}
}