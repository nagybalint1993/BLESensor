package kpwhrj.blesensor;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BalintGyorgy on 2015.03.11..
 */
public class LeDeviceListAdapter extends BaseAdapter{

    public List<BluetoothDevice> blelist;

    public LeDeviceListAdapter(){
        blelist= new ArrayList<BluetoothDevice>();
    }

    @Override
    public int getCount() {
        return blelist.size();
    }

    @Override
    public Object getItem(int position) {
        return blelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final BluetoothDevice device= blelist.get(position);

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.devicerow, null);

        TextView tvName = (TextView) itemView.findViewById(R.id.TVDeviceName);
        tvName.setText(device.getName());
        TextView tvAddress= (TextView) itemView.findViewById(R.id.TVDeviceAddress);
        tvAddress.setText(device.getAddress());

        return itemView;
    }

    public void addDevice(BluetoothDevice device) {
        if(!blelist.contains(device)) {
            blelist.add(device);
        }
    }

    public void clear() {
        blelist.clear();
    }


    public BluetoothDevice getDevice(int position) {
        return blelist.get(position);
    }
}
