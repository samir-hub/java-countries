package com.samir.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int landmass;
    private int medAge;

    public Country(String name, int population, int landmass, int medAge)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landmass = landmass;
        this.medAge = medAge;
    }

    public Country(Country toClone)
        {
            this.id = toClone.getId();
            this.name = toClone.getName();
            this.population = toClone.getPopulation();
            this.landmass = toClone.getLandmass();
            this.medAge = toClone.getMedAge();
        }


    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getLandmass()
    {
        return landmass;
    }

    public void setLandmass(int landmass)
    {
        this.landmass = landmass;
    }

    public int getMedAge()
    {
        return medAge;
    }

    public void setMedAge(int medAge)
    {
        this.medAge = medAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + ", landmass=" + landmass + ", medAge=" + medAge + '}';
    }
}
