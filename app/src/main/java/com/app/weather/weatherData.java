package com.app.weather;
import org.json.JSONObject;
import org.json.JSONException;
public class weatherData {


    private String meTemperature,mCity,mWeatherType,mIcon;
    private int mCondition;

    public static weatherData FromJson(JSONObject jsonObject){
        try{
            weatherData weatherD=new weatherData();
            weatherD.mCity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.mIcon=updateWeatherIcon(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.meTemperature=Integer.toString(roundedValue);
            return weatherD;
        }
        catch(JSONException e){
            e.printStackTrace();
            return null;
        }
    }

    private static String updateWeatherIcon(int Condition) {
        if(Condition>=0&& Condition<=300){
            return "thunderstorm1";
        }
        else if(Condition>=300&& Condition<=500){
            return "lightrain";
        }
        else if(Condition>=500&& Condition<=600){
            return "shower";
        }
        else if(Condition>=600&& Condition<=700){
            return "snow";
        }
        else if(Condition>=701&& Condition<=771){
            return "fog";
        }
        else if(Condition>=772&& Condition<=800){
            return "overcast";
        }
        else if(Condition==800){
            return "sunny";
        }
        else if(Condition>801&&Condition<=804){
            return "cloudy";
        }
        else if(Condition>900&&Condition<=902){
            return "thunderstorm1";
        }
        else if(Condition==903){
            return "snow1";
        }
        else if(Condition==904){
            return "sunny";
        }
        else if(Condition==905&&Condition<=1000){
            return "thunderstorm2";
        }
        return "dunno";
    }

    public String getMeTemperature() {
        return meTemperature+"°C";
    }

    public String getmCity() {
        return mCity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }

    public String getmIcon() {
        return mIcon;
    }
}
