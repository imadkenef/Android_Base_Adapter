# Android_Base_Adapter
> Read this Code to know to use Base Adapter to show a list of countries & flags in Ui.

1. Firstly:
> I create custom view '(R.layout.countries_view.xml)' that containe ImageView for flags countrie & TextView for names of countries.
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:orientation="horizontal">

		<ImageView
			android:id="@+id/flags"
			android:layout_width="100dp"
			android:layout_height="100dp"
			android:scaleType="center"
			android:layout_marginTop="10dp"
			android:layout_marginStart="10dp"
			android:layout_marginBottom="10dp"
			android:layout_marginEnd="10dp"/>

    	<TextView
			android:id="@+id/countries"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:text="Countries"
			android:textSize="30sp"
			android:layout_gravity="center_vertical"/>
	</LinearLayout>

2. secondly:
> I create a two lists of countries & add flags in drawable resource.
	String[] counties = {
          "IRAQ","IRELAND","USA","JORDON",.....
        };
        //List of Flags
        int[] flags = {
                R.drawable.iraq,
                R.drawable.irland,
                R.drawable.usa,
                R.drawable.jordon,
				......
        };

3. Third:
> I create a base adapter 'CountriesAdapters' & ViewHolder 'ViewHolderCountries'.
	public class CountriesAdapters extends BaseAdapter {
		private Context context;
		private String[] countries;
		private int[] flags;


		public CountriesAdapters(Context context, String[] countries, int[] flags) {
			this.context = context;
			this.countries = countries;
			this.flags = flags;
		}

		@Override
		public int getCount() {
			return countries.length;
		}

		@Override
		public Object getItem(int position) {
			return countries[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolderCountries holder;
			if (convertView == null){
				convertView = LayoutInflater.from(context).inflate(R.layout.countries_view,parent,false);
				holder = new ViewHolderCountries();
				holder.textView = convertView.findViewById(R.id.countries);
				holder.imageView = convertView.findViewById(R.id.flags);
				convertView.setTag(holder);
			}else{
				holder = (ViewHolderCountries) convertView.getTag();
			}
			holder.textView.setText(countries[position]);
			holder.imageView.setImageResource(flags[position]);
			return convertView;
		}
		static class ViewHolderCountries{
			ImageView imageView;
			TextView textView;
		}

	}

4. Fourthly:
> Link this Lists with aadpter.
	CountriesAdapters countriesAdapters = new CountriesAdapters(this,counties,flags);
    listView.setAdapter(countriesAdapters);