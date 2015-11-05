package com.csc436.team_bubble_sort.lunchroll.model.user;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;

import com.csc436.team_bubble_sort.lunchroll.model.group.GroupsCalls;
import com.csc436.team_bubble_sort.lunchroll.model.group.UserGroup;
import com.csc436.team_bubble_sort.lunchroll.model.locations.ClientNearbyAnyCalls;
import com.csc436.team_bubble_sort.lunchroll.model.preferences.CategoryOfFoodPreferences;
import com.csc436.team_bubble_sort.lunchroll.model.preferences.PreferencesCalls;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

//TODO implement Parcelable instead of Serializable for performance boost
public class AppUser implements PreferencesCalls, Comparable<AppUser>, ClientNearbyAnyCalls, UsersCalls, GroupsCalls, Serializable {
    private CategoryOfFoodPreferences preferences;
    private ArrayList<UserGroup> userGroups;
    private String username;
    private ArrayList<AppUser> friendsList;
    private String email;
    private BigDecimal phoneNumber;
    private Point location;

    public AppUser(String username, CategoryOfFoodPreferences preferences){
        this.username = username;
        this.preferences = preferences;
        this.userGroups = new ArrayList<>();
        this.friendsList = new ArrayList<>();
    }

    public ArrayList<String> getGroupNames(){
        ArrayList<String> groupNames = new ArrayList<>();
        for(UserGroup group : userGroups){
            groupNames.add(group.getGroupName());
        }
        return groupNames;
    }

    public ArrayList<String> getFriendsNames(){
        ArrayList<String> friends = new ArrayList<>();
        for(AppUser friend : friendsList){
            friends.add(friend.getUsername());
        }
        return friends;
    }

    // TODO Helps build JSON object in string form
    @Override
    public String toString(){
        JSONObject json_appuser = new JSONObject();
        JSONArray json_usergroups = new JSONArray();
        try {
            json_appuser.accumulate("name", username);
            json_appuser.accumulate("preferences", preferences.toString());
            for(UserGroup group : userGroups){
                json_usergroups.put(group.toString());
            }
            json_appuser.accumulate("user_groups", json_usergroups);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json_appuser.toString();
    }
    // Allows a list of appUsers to be compared
    @Override
    public int compareTo(AppUser another) {
        if (this.username.compareTo(another.username) < 0) return -1;
        else if(this.username.compareTo(another.username) > 0) return 1;
        else return 0;
    }

    // Getters and Setters
    public CategoryOfFoodPreferences getPreferences(){return preferences;}
    public void setPreferences(CategoryOfFoodPreferences newPreferences){preferences = newPreferences;}
    public ArrayList<UserGroup> getUserGroups(){return userGroups;}
    public void setUserGroups(ArrayList<UserGroup> newUserGroups){userGroups = newUserGroups;}
    public String getUsername(){return username;}
    public void setUsername(String newUserID){username = newUserID;}
    public void setFriendsList(ArrayList<AppUser> newFriendsList){
        friendsList = newFriendsList;
    }
    public ArrayList<AppUser> getFriendsList(){
        return friendsList;
    }

    // TODO Web Service Calls
    @Override
    public void savePreferenceList() {

    }

    @Override
    public void loadPreferenceList() {

    }

    @Override
    public void clientNearbyAnyRequest() {

    }

    @Override
    public void clientNearbyAnySuccess() {

    }

    @Override
    public String clientNearbyAnyError() {
        return null;
    }

    @Override
    public void saveUser() {

    }

    @Override
    public void loadUser() {

    }

    @Override
    public void saveGroup() {

    }

    @Override
    public void loadGroup() {

    }

    @Override
    public void saveGroups() {

    }

    @Override
    public void loadGroups() {

    }
}
