package com.trustbirungi.xtremesoundboardmario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class Home extends Activity {
	
	String soundName = "";
	
	public String[] filenames = {"Stage clear", "World clear", "Running out of time", "Mario dies", "Game over", "1-Up", "Bowser falls", "Bowser's fire", "Brick smash", "Bump", "Coin", "Down the flagpole", "Fireball", "Fireworks", "Jump", "Pipe travel", "Power up", "Power-up appears", "Stomp", "Vine growing", "Battle start", "Fire", "Hammer", "High jump", "Luigi jump", "Jump off barrel", "Jump onto barrel", "Lets go", "Luigi", "Luigi busts out of barrel", "Mario", "Okee dokee", "Peach in distress", "Spin", "Spin jump", "Thunder", "Yah", "Yah oh", "Blargg", "Bonus game end", "Bowser is defeated", "Bowser flies away", "Bowser returns", "Bubble pops", "Castle clear", "Course clear", "Door opens", "Egg hatching", "Game over", "Keyhole exit", "Lava bubble", "Lost a life", "Magikoopa beam", "Princess calls for help", "Swimming", "Switch activated", "Yoshi fire attack", "Yoshi runs away"};
	
	int[] sound_index = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
	
	MediaPlayer stage_clear, world_clear, out_of_time, mario_dies, game_over, one_up, bowser_falls, bowser_fire, brick_smash, bump, coin, down_the_flagpole, fireball, fireworks, jump, pipe_travel, power_up, power_up_appears, stomp, vine_growing, battle_start, fire, hammer, high_jump, l_jump, jump_off_barrel, jump_onto_barrel, lets_go, luigi, luigi_out_of_barrel, mario, okee_dokee, peach_in_distress, spin, spin_jump, thunder, yah, yah_oh, blargg, bonus_game_end, bowser_defeated, bowser_flies_away, bowser_returns, bubble_pop, castle_clear, course_clear, door_opens, egg_hatching, world_game_over, keyhole_exit, lava_bubble, lost_a_life, magikoopa_beam, princess_help, swimming, switch_activated, yoshi_fire_attack, yoshi_runs_away;
	
	MediaPlayer current_sound;
	
	public GridView gridview;
	
	public String[] Sounds;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        gridview = (GridView) findViewById(R.id.gridView1);
        gridview.setAdapter(new ButtonAdapter(this));
        registerForContextMenu(gridview);
        
        current_sound = MediaPlayer.create(Home.this, R.raw.blank);
		current_sound.start();
		
		Sounds = getResources().getStringArray(R.array.sounds);
		
		
		gridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				switch (sound_index[arg2]) {
		  		case 0:
		  			current_sound.release();
		  			stage_clear = MediaPlayer.create(Home.this, R.raw.stage_clear);
		  			current_sound = stage_clear;
		  			stage_clear.start();
		  			break;

		  		case 1:
		  			current_sound.release();
		  			world_clear = MediaPlayer.create(Home.this, R.raw.world_clear);
		  			current_sound = world_clear;
		  			world_clear.start();
		  			break;
		  			
		  		case 2:
		  			current_sound.release();
		  			out_of_time = MediaPlayer.create(Home.this, R.raw.out_of_time);
		  			current_sound = out_of_time;
		  			out_of_time.start();
		  			break;
		  		
		  		case 3:
		  			current_sound.release();
		  			mario_dies = MediaPlayer.create(Home.this, R.raw.mario_dies);
		  			current_sound = mario_dies;
		  			mario_dies.start();
		  			break;
		  			
		  		case 4:
		  			current_sound.release();
		  			game_over = MediaPlayer.create(Home.this, R.raw.game_over);
		  			current_sound = game_over;
		  			game_over.start();
		  			break;
		  			
		  		case 5:
		  			current_sound.release();
		  			one_up = MediaPlayer.create(Home.this, R.raw.one_up);
		  			current_sound = one_up;
		  			one_up.start();
		  			break;
		  			
		  		case 6:
		  			current_sound.release();
		  			bowser_falls = MediaPlayer.create(Home.this, R.raw.bowserfalls);
		  			current_sound = bowser_falls;
		  			bowser_falls.start();
		  			break;
		  			
		  		case 7:
		  			current_sound.release();
		  			bowser_fire = MediaPlayer.create(Home.this, R.raw.bowser_fire);
		  			current_sound = bowser_fire;
		  			bowser_fire.start();
		  			break;

		  		case 8:
		  			current_sound.release();
		  			brick_smash = MediaPlayer.create(Home.this, R.raw.brick_smash);
		  			current_sound = brick_smash;
		  			brick_smash.start();
		  			break;

		  		case 9:
		  			current_sound.release();
		  			bump = MediaPlayer.create(Home.this, R.raw.bump);
		  			current_sound = bump;
		  			bump.start();
		  			break;

		  		case 10:
		  			current_sound.release();
		  			coin = MediaPlayer.create(Home.this, R.raw.coin);
		  			current_sound = coin;
		  			coin.start();
		  			break;

		  		case 11:
		  			current_sound.release();
		  			down_the_flagpole = MediaPlayer.create(Home.this, R.raw.down_the_flagpole);
		  			current_sound = down_the_flagpole;
		  			down_the_flagpole.start();
		  			break;

		  		case 12:
		  			current_sound.release();
		  			fireball= MediaPlayer.create(Home.this, R.raw.fireball);
		  			current_sound = fireball;
		  			fireball.start();
		  			break;

		  		case 13:
		  			current_sound.release();
		  			fireworks = MediaPlayer.create(Home.this, R.raw.fireworks);
		  			current_sound = fireworks;
		  			fireworks.start();
		  			break;

		  		case 14:
		  			current_sound.release();
		  			jump = MediaPlayer.create(Home.this, R.raw.jump);
		  			current_sound = jump;
		  			jump.start();
		  			break;

		  		case 15:
		  			current_sound.release();
		  			pipe_travel = MediaPlayer.create(Home.this, R.raw.pipe_travel);
		  			current_sound = pipe_travel;
		  			pipe_travel.start();
		  			break;

		  		case 16:
		  			current_sound.release();
		  			power_up = MediaPlayer.create(Home.this, R.raw.power_up);
		  			current_sound = power_up;
		  			power_up.start();
		  			break;

		  		case 17:
		  			current_sound.release();
		  			power_up_appears = MediaPlayer.create(Home.this, R.raw.power_up_appears);
		  			current_sound = power_up_appears;
		  			power_up_appears.start();
		  			break;

		  		case 18:
		  			current_sound.release();
		  			stomp = MediaPlayer.create(Home.this, R.raw.stomp);
		  			current_sound = stomp;
		  			stomp.start();
		  			break;

		  		case 19:
		  			current_sound.release();
		  			vine_growing = MediaPlayer.create(Home.this, R.raw.vine_growing);
		  			current_sound = vine_growing;
		  			vine_growing.start();
		  			break;
		  		
		  		case 20:
	      			current_sound.release();
	      			battle_start = MediaPlayer.create(Home.this, R.raw.battle_start);
	      			current_sound = battle_start;
	      			battle_start.start();
	      			break;

	      		case 21:
	      			current_sound.release();
	      			fire= MediaPlayer.create(Home.this, R.raw.fire);
	      			current_sound = fire;
	      			fire.start();
	      			break;
	      			
	      		case 22:
	      			current_sound.release();
	      			hammer = MediaPlayer.create(Home.this, R.raw.hammer);
	      			current_sound = hammer;
	      			hammer.start();
	      			break;
	      		
	      		case 23:
	      			current_sound.release();
	      			high_jump = MediaPlayer.create(Home.this, R.raw.high_jump);
	      			current_sound = high_jump;
	      			high_jump.start();
	      			break;
	      			
	      		case 24:
	      			current_sound.release();
	      			l_jump = MediaPlayer.create(Home.this, R.raw.jump);
	      			current_sound = l_jump;
	      			l_jump.start();
	      			break;
	      			
	      		case 25:
	      			current_sound.release();
	      			jump_off_barrel = MediaPlayer.create(Home.this, R.raw.jump_off_barrel);
	      			current_sound = jump_off_barrel;
	      			jump_off_barrel.start();
	      			break;
	      			
	      		case 26:
	      			current_sound.release();
	      			jump_onto_barrel = MediaPlayer.create(Home.this, R.raw.jump_onto_barrel);
	      			current_sound = jump_onto_barrel;
	      			jump_onto_barrel.start();
	      			break;
	      			
	      		case 27:
	      			current_sound.release();
	      			lets_go = MediaPlayer.create(Home.this, R.raw.lets_go);
	      			current_sound = lets_go;
	      			lets_go.start();
	      			break;

	      		case 28:
	      			current_sound.release();
	      			luigi = MediaPlayer.create(Home.this, R.raw.luigi);
	      			current_sound = luigi;
	      			luigi.start();
	      			break;

	      		case 29:
	      			current_sound.release();
	      			luigi_out_of_barrel = MediaPlayer.create(Home.this, R.raw.luigi_out_of_barrel);
	      			current_sound = luigi_out_of_barrel;
	      			luigi_out_of_barrel.start();
	      			break;

	      		case 30:
	      			current_sound.release();
	      			mario = MediaPlayer.create(Home.this, R.raw.mario);
	      			current_sound = mario;
	      			mario.start();
	      			break;

	      		case 31:
	      			current_sound.release();
	      			okee_dokee = MediaPlayer.create(Home.this, R.raw.okee_dokee);
	      			current_sound = okee_dokee;
	      			okee_dokee.start();
	      			break;

	      		case 32:
	      			current_sound.release();
	      			peach_in_distress= MediaPlayer.create(Home.this, R.raw.peach_in_distress);
	      			current_sound = peach_in_distress;
	      			peach_in_distress.start();
	      			break;

	      		case 33:
	      			current_sound.release();
	      			spin = MediaPlayer.create(Home.this, R.raw.spin);
	      			current_sound = spin;
	      			spin.start();
	      			break;

	      		case 34:
	      			current_sound.release();
	      			spin_jump = MediaPlayer.create(Home.this, R.raw.spin_jump);
	      			current_sound = spin_jump;
	      			spin_jump.start();
	      			break;

	      		case 35:
	      			current_sound.release();
	      			thunder = MediaPlayer.create(Home.this, R.raw.thunder);
	      			current_sound = thunder;
	      			thunder.start();
	      			break;

	      		case 36:
	      			current_sound.release();
	      			yah = MediaPlayer.create(Home.this, R.raw.yah);
	      			current_sound = yah;
	      			yah.start();
	      			break;

	      		case 37:
	      			current_sound.release();
	      			yah_oh = MediaPlayer.create(Home.this, R.raw.yah_oh);
	      			current_sound = yah_oh;
	      			yah_oh.start();
	      			break;
	      			
	      		case 38:
	      			current_sound.release();
	      			blargg = MediaPlayer.create(Home.this, R.raw.blargg);
	      			current_sound = blargg;
	      			blargg.start();
	      			break;

	      		case 39:
	      			current_sound.release();
	      			bonus_game_end = MediaPlayer.create(Home.this, R.raw.bonus_game_end);
	      			current_sound = bonus_game_end;
	      			bonus_game_end.start();
	      			break;
	      			
	      		case 40:
	      			current_sound.release();
	      			bowser_defeated = MediaPlayer.create(Home.this, R.raw.bowser_defeated);
	      			current_sound = bowser_defeated;
	      			bowser_defeated.start();
	      			break;
	      		
	      		case 41:
	      			current_sound.release();
	      			bowser_flies_away = MediaPlayer.create(Home.this, R.raw.bowser_flies_away);
	      			current_sound = bowser_flies_away;
	      			bowser_flies_away.start();
	      			break;
	      			
	      		case 42:
	      			current_sound.release();
	      			bowser_returns = MediaPlayer.create(Home.this, R.raw.bowser_returns);
	      			current_sound = bowser_returns;
	      			bowser_returns.start();
	      			break;
	      			
	      		case 43:
	      			current_sound.release();
	      			bubble_pop = MediaPlayer.create(Home.this, R.raw.bubble_pop);
	      			current_sound = bubble_pop;
	      			bubble_pop.start();
	      			break;
	      			
	      		case 44:
	      			current_sound.release();
	      			castle_clear = MediaPlayer.create(Home.this, R.raw.castle_clear);
	      			current_sound = castle_clear;
	      			castle_clear.start();
	      			break;
	      			
	      		case 45:
	      			current_sound.release();
	      			course_clear = MediaPlayer.create(Home.this, R.raw.course_clear);
	      			current_sound = course_clear;
	      			course_clear.start();
	      			break;

	      		case 46:
	      			current_sound.release();
	      			door_opens = MediaPlayer.create(Home.this, R.raw.door_opens);
	      			current_sound = door_opens;
	      			door_opens.start();
	      			break;

	      		case 47:
	      			current_sound.release();
	      			egg_hatching = MediaPlayer.create(Home.this, R.raw.egg_hatching);
	      			current_sound = egg_hatching;
	      			egg_hatching.start();
	      			break;
	      			
	      		case 48:
	      			current_sound.release();
	      			world_game_over = MediaPlayer.create(Home.this, R.raw.world_game_over);
	      			current_sound = world_game_over;
	      			world_game_over.start();
	      			break;

	      		case 49:
	      			current_sound.release();
	      			keyhole_exit = MediaPlayer.create(Home.this, R.raw.keyhole_exit);
	      			current_sound = keyhole_exit;
	      			keyhole_exit.start();
	      			break;

	      		case 50:
	      			current_sound.release();
	      			lava_bubble = MediaPlayer.create(Home.this, R.raw.lava_bubble);
	      			current_sound = lava_bubble;
	      			lava_bubble.start();
	      			break;

	      		case 51:
	      			current_sound.release();
	      			lost_a_life = MediaPlayer.create(Home.this, R.raw.lost_a_life);
	      			current_sound = lost_a_life;
	      			lost_a_life.start();
	      			break;

	      		case 52:
	      			current_sound.release();
	      			magikoopa_beam = MediaPlayer.create(Home.this, R.raw.magikoopa_beam);
	      			current_sound = magikoopa_beam;
	      			magikoopa_beam.start();
	      			break;

	      		case 53:
	      			current_sound.release();
	      			princess_help = MediaPlayer.create(Home.this, R.raw.princess_help);
	      			current_sound = princess_help;
	      			princess_help.start();
	      			break;

	      		case 54:
	      			current_sound.release();
	      			swimming = MediaPlayer.create(Home.this, R.raw.swimming);
	      			current_sound = swimming;
	      			swimming.start();
	      			break;

	      		case 55:
	      			current_sound.release();
	      			switch_activated = MediaPlayer.create(Home.this, R.raw.switch_activated);
	      			current_sound = switch_activated;
	      			switch_activated.start();
	      			break;

	      		case 56:
	      			current_sound.release();
	      			yoshi_fire_attack = MediaPlayer.create(Home.this, R.raw.yoshi_fire_attack);
	      			current_sound = yoshi_fire_attack;
	      			yoshi_fire_attack.start();
	      			break;
	      			
	      		case 57:
	      			current_sound.release();
	      			yoshi_runs_away = MediaPlayer.create(Home.this, R.raw.yoshi_runs_away);
	      			current_sound = yoshi_runs_away;
	      			yoshi_runs_away.start();
	      			break;
		  			
		  		}

			}
		});
	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    
    
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
	super.onCreateContextMenu(menu, v, menuInfo);
	if (v.getId()==R.id.gridView1) {
	    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
		menu.setHeaderTitle("Set Sound As");
		String[] menuItems = getResources().getStringArray(R.array.menu); 
		for (int i = 0; i<menuItems.length; i++) {
			menu.add(Menu.NONE, i, i, menuItems[i]);
		}
	}
  }
    
    @Override
	public boolean onContextItemSelected(MenuItem item) {
    	AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
	    int menuItemIndex = item.getItemId();
		String[] menuItems = getResources().getStringArray(R.array.menu);
		String menuItemName = menuItems[menuItemIndex];
	    String listItemName = filenames[info.position];
	    soundName = listItemName;
	    
	    
	    if(menuItemName.equals("Ringtone") || menuItemName.equals("Alarm") || menuItemName.equals("Notification")) {
	
	    if(listItemName.equalsIgnoreCase(filenames[0])) {
	    	saveas(R.raw.stage_clear, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[1])) {
	    	saveas(R.raw.world_clear, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[2])) {
	    	saveas(R.raw.out_of_time, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[3])) {
	    	saveas(R.raw.mario_dies, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[4])) {
	    	saveas(R.raw.game_over, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[5])) {
	    	saveas(R.raw.one_up, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[6])) {
	    	saveas(R.raw.bowserfalls, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[7])) {
	    	saveas(R.raw.bowser_fire, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[8])) {
	    	saveas(R.raw.brick_smash, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[9])) {
	    	saveas(R.raw.bump, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[10])) {
	    	saveas(R.raw.coin, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[11])) {
	    	saveas(R.raw.down_the_flagpole, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[12])) {
	    	saveas(R.raw.fireball, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[13])) {
	    	saveas(R.raw.fireworks, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[14])) {
	    	saveas(R.raw.jump, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[15])) {
	    	saveas(R.raw.pipe_travel, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[16])) {
	    	saveas(R.raw.power_up, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[17])) {
	    	saveas(R.raw.power_up_appears, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[18])) {
	    	saveas(R.raw.stomp, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[19])) {
	    	saveas(R.raw.vine_growing, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[20])) {
	    	saveas(R.raw.battle_start, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[21])) {
	    	saveas(R.raw.fire, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[22])) {
	    	saveas(R.raw.hammer, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[23])) {
	    	saveas(R.raw.high_jump, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[24])) {
	    	saveas(R.raw.jump, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[25])) {
	    	saveas(R.raw.jump_off_barrel, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[26])) {
	    	saveas(R.raw.jump_onto_barrel, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[27])) {
	    	saveas(R.raw.lets_go, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[28])) {
	    	saveas(R.raw.luigi, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[29])) {
	    	saveas(R.raw.luigi_out_of_barrel, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[30])) {
	    	saveas(R.raw.mario, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[31])) {
	    	saveas(R.raw.okee_dokee, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[32])) {
	    	saveas(R.raw.peach_in_distress, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[33])) {
	    	saveas(R.raw.spin, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[34])) {
	    	saveas(R.raw.spin_jump, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[35])) {
	    	saveas(R.raw.thunder, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[36])) {
	    	saveas(R.raw.yah, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[37])) {
	    	saveas(R.raw.yah_oh, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[38])) {
	    	saveas(R.raw.blargg, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[39])) {
	    	saveas(R.raw.bonus_game_end, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[40])) {
	    	saveas(R.raw.bowser_defeated, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[41])) {
	    	saveas(R.raw.bowser_flies_away, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[42])) {
	    	saveas(R.raw.bowser_returns, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[43])) {
	    	saveas(R.raw.bubble_pop, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[44])) {
	    	saveas(R.raw.castle_clear, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[45])) {
	    	saveas(R.raw.course_clear, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[46])) {
	    	saveas(R.raw.door_opens, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[47])) {
	    	saveas(R.raw.egg_hatching, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[48])) {
	    	saveas(R.raw.world_game_over, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[49])) {
	    	saveas(R.raw.keyhole_exit, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[50])) {
	    	saveas(R.raw.lava_bubble, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[51])) {
	    	saveas(R.raw.lost_a_life, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[52])) {
	    	saveas(R.raw.magikoopa_beam, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[53])) {
	    	saveas(R.raw.princess_help, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[54])) {
	    	saveas(R.raw.swimming, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[55])) {
	    	saveas(R.raw.switch_activated, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[56])) {
	    	saveas(R.raw.yoshi_fire_attack, menuItemName);
	    }else if(listItemName.equalsIgnoreCase(filenames[57])) {
	    	saveas(R.raw.yoshi_runs_away, menuItemName);
	    }//End inner if
	    }//End outer if
	    
	    
    	return true;
	}
    
    
    public boolean saveas(int ressound, String notif_type){
     	 byte[] buffer = null;
     	 InputStream fIn = getBaseContext().getResources().openRawResource(ressound);
     	 int size = 0;
     	 
     	 String baseDir = "";

     	 try {
     	  size = fIn.available();
     	  buffer = new byte[size];
     	  fIn.read(buffer);
     	  fIn.close();
     	 } catch (IOException e) {
     	  return false;
     	 }

     	 String filename= soundName + ".ogg";
     	 
     	 if(notif_type.equals("Ringtone")) {
     		 baseDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath();
     	 }else if(notif_type.equals("Alarm")) {
     		 baseDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).getAbsolutePath();
     	 }else if(notif_type.equals("Notification")) {
     		 baseDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS).getAbsolutePath();
     	 }

     	 boolean exists = (new File(baseDir)).exists();
     	 if (!exists){new File(baseDir).mkdirs();}

     	 FileOutputStream save;
     	 try {
     	  save = new FileOutputStream(baseDir + File.separator + filename);
     	  save.write(buffer);
     	  save.flush();
     	  save.close();
     	 } catch (FileNotFoundException e) {
     	  // TODO Auto-generated catch block
     	  return false;
     	 } catch (IOException e) {
     	  // TODO Auto-generated catch block
     	  return false;
     	 }    

     	 sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + baseDir + File.separator + filename)));

     	 File k = new File(baseDir, filename);

     	 ContentValues values = new ContentValues();
     	 values.put(MediaStore.MediaColumns.DATA, k.getAbsolutePath());
     	 values.put(MediaStore.MediaColumns.TITLE, soundName);
     	 values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/ogg");
     	 values.put(MediaStore.Audio.Media.ARTIST, "mariosounds");
     	 values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
     	 values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
     	 values.put(MediaStore.Audio.Media.IS_ALARM, true);
     	 values.put(MediaStore.Audio.Media.IS_MUSIC, false);

     	 //Insert it into the database and set as active ringtone
     	 Uri uri = MediaStore.Audio.Media.getContentUriForPath(k.getAbsolutePath());

          getContentResolver().delete(uri, MediaStore.MediaColumns.DATA + "=\"" + k.getAbsolutePath() + "\"", null);

          Uri newUri = getContentResolver().insert(uri, values);

          
          if(notif_type.equals("Ringtone")) {
         	 RingtoneManager.setActualDefaultRingtoneUri(
                      Home.this,
                RingtoneManager.TYPE_RINGTONE,
                newUri
              );
     	 }else if(notif_type.equals("Alarm")) {
     		 RingtoneManager.setActualDefaultRingtoneUri(
                      Home.this,
                RingtoneManager.TYPE_ALARM,
                newUri
              );
     	 }else if(notif_type.equals("Notification")) {
     		 RingtoneManager.setActualDefaultRingtoneUri(
                      Home.this,
                RingtoneManager.TYPE_NOTIFICATION,
                newUri
              );
     	 }
          

     	 return true;
     	}

   
    public class ButtonAdapter extends BaseAdapter {
   	 private Context mContext;

   	 // Gets the context so it can be used later
   	 public ButtonAdapter(Context c) {
   	  mContext = c;
   	 }
   	 

   	 // Total number of things contained within the adapter
   	 public int getCount() {
   	  return filenames.length;
   	 }

   	  // Require for structure, not really used in my code.
   	 public Object getItem(int position) {
   	  return null;
   	 }

   	 
   	 // Can be used to get the id of an item in the adapter for manual control.
   	 public long getItemId(int position) {
   	  return position;
   	 }
   	 
   	 public View getView(int position, View convertView, ViewGroup parent) {
   	  Button btn;
   	  if (convertView == null) {
   	   // if it's not recycled, initialize some attributes
   	   btn = new Button(mContext);
   	   btn.setLayoutParams(new GridView.LayoutParams(220, 110));
   	   btn.setPadding(15, 15, 15, 15);
   	btn.setFocusable(false);
    btn.setClickable(false);
   	   }
   	  else {
   	   btn = (Button) convertView;
   	  }
 
   	  btn.setText(filenames[position]);
   	  btn.setTextColor(Color.WHITE);
   	  btn.setBackgroundResource(R.drawable.blue_button);
   	  btn.setId(position);
   	  return btn;
   	}
   	 
  }
    
}

