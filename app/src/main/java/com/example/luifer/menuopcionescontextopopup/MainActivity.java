package com.example.luifer.menuopcionescontextopopup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvNombre=(TextView)findViewById(R.id.tvNombre);
        registerForContextMenu(tvNombre);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//este metodo es para mostrar el menu
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;

    }

    /*en este metodo se usa para controlar lo que esta dentro del menu cuando le damos click que
        pasara*/

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
/*el swich sirve para comprar en que item estamos por medio de su id como tenemos dos item son dos
   casos ypara controlar que pasa en cada uno */
            case R.id.MAbout:
                Intent intent =new Intent(this,ActivityAbout.class);
                startActivity(intent);
                //en este caso llamamos la actividad de about por medio de Intent
                break;

            case R.id.mSettings:
                Intent intent1 =new Intent(this,ActivitySettings.class);
                startActivity(intent1);
                //aqui llamamos la actividad de settings
                break;


                    case (R.id.mRefresh):
                        break;





        }

        return super.onOptionsItemSelected(item);


    }









    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=new MenuInflater(this);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case (R.id.medit):
                Intent intent =new Intent(this,ActivityAbout.class);
                startActivity(intent);
                Toast.makeText(this,getResources().getString(R.string.menu_edit),Toast.LENGTH_SHORT).show();
                break;
            case (R.id.mdelete):
                Intent intent1 =new Intent(this,ActivityAbout.class);
                startActivity(intent1);
                Toast.makeText(this,getResources().getString(R.string.menu_delete),Toast.LENGTH_SHORT).show();
                break;
        }



        return super.onContextItemSelected(item);
    }


    public void levantarMenuPopup( View v ){
        ImageView imagen=(ImageView)findViewById(R.id.imgImagen);
        PopupMenu popupMenu=new PopupMenu(this,imagen);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            public boolean onMenuItemClick(MenuItem item){
                switch(item.getItemId()){
                    case(R.id.mView):
                        Toast.makeText(getBaseContext(),getResources().getString(R.string.menu_View),Toast.LENGTH_LONG).show();
                        break;
                    case (R.id.mViewDetail):
                        Toast.makeText(getBaseContext(),getResources().getString(R.string.menu_ViewDetaiel),Toast.LENGTH_LONG).show();
                        break;

                }
                return true;
            }
        });

        popupMenu.show();//esto es para mostrar lo que tiene nuestro metodo

    }

}
