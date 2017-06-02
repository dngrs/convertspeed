package com.convertspeed;

import javax.xml.bind.annotation.*;

/**
 * Created by Igor Odokienko
 */

/**
 * Class is used for modification initial SOAP request (ConvertSpeed.class)
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "speed",
        "fromUnit",
        "toUnit"
})
@XmlRootElement(name = "ConvertSpeedExt")
public class ConvertSpeedExt {

    //
    protected String speed;
    @XmlElement(name = "FromUnit", required = true)
    protected SpeedUnit fromUnit;
    @XmlElement(name = "ToUnit", required = true)
    protected SpeedUnit toUnit;

    public SpeedUnit getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(SpeedUnit value) {
        this.fromUnit = value;
    }

    public SpeedUnit getToUnit() {
        return toUnit;
    }

    public void setToUnit(SpeedUnit value) {
        this.toUnit = value;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String value) {
        this.speed = value;
    }

}
