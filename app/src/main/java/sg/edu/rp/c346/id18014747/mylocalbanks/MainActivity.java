package sg.edu.rp.c346.id18014747.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvDBS) {
            menu.add(0, v.getId(), 0, "Website");
            menu.add(0, v.getId(), 1, "Contact the Bank");
        } else if (v == tvOCBC) {
            menu.add(0, v.getId(), 0, "Website");
            menu.add(0, v.getId(), 1, "Contact the Bank");
        } else if (v == tvUOB) {
            menu.add(0, v.getId(), 0, "Website");
            menu.add(0, v.getId(), 1, "Contact the Bank");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == tvDBS.getId()) {
            if (item.getOrder() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            }
            if (item.getOrder() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"1800-111-1111"));
                startActivity(intentCall);
                return true;
            }
        } else if (id == tvOCBC.getId()) {
            if (item.getOrder() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            }
            if (item.getOrder() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"1800-363-3333"));
                startActivity(intentCall);
                return true;
            }
        } else {
            if (item.getOrder() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            }
            if (item.getOrder() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"1800-222-2121"));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(getString(R.string.cbank1));
            tvOCBC.setText(getString(R.string.cbank2));
            tvUOB.setText(getString(R.string.cbank3));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
