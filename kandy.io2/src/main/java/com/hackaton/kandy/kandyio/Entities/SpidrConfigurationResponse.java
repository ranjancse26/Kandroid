package com.hackaton.kandy.kandyio.Entities;

/**
 * Created by RanjanD on 3/20/2017.
 */

public class SpidrConfigurationResponse {

    private SpidrConfiguration spidr_configuration;

    public SpidrConfiguration getSpidr_configuration ()
    {
        return spidr_configuration;
    }

    public void setSpidr_configuration (SpidrConfiguration spidr_configuration)
    {
        this.spidr_configuration = spidr_configuration;
    }

    @Override
    public String toString()
    {
        return "SpidrConfigurationResponse [SpidrConfiguration = "+spidr_configuration+"]";
    }
}
