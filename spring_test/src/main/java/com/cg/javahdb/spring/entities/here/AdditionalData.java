package com.cg.javahdb.spring.entities.here;

/**
 *
 * @author GBANGALO
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdditionalData
{
	@JsonProperty("value")
    private String value;
	@JsonProperty("key")
    private String key;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    @Override
    public String toString()
    {
        return "value : "+value+", key : "+key;
    }
}