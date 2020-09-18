package edu.miracosta.cs113;

public class Term implements Comparable<Term>
{

    private int expo;
    private int coeff;

//  Default Constructor
    Term()
    {
        expo = 1;
        coeff = 1;
    }

//  Full Constructor
    Term(int coeff, int expo)
    {
        this.coeff = coeff;
        this.expo = expo;
    }

//  Accepts As String
    Term(String term)
    {
        int i = 0;
        for (String a: term.split("x\\^|x")) {
            if (i == 0)
            {
                if (a.equals("-"))
                {
                    this.coeff = -1;
                }
                else if (a.equals("+"))
                {
                    this.coeff = 1;
                }
                else if (a.equals(""))
                {
                    this.coeff = 0;
                    this.expo = 0;
                }
                else
                {
                    this.coeff = Integer.parseInt(a);
                }
                if (term.equals("-x") || term.equals("+x") || term.equals("+" + coeff + "x") || term.equals(coeff + "x"))
                {
                    this.expo = 1;
                }
                i = 1;
            }
            else
            {
                this.expo = Integer.parseInt(a);
            }
        }
    }

//  Copy Constructor
    Term(Term other)
    {
        this.expo = other.getExponent();
        this.coeff = other.getCoefficient();
    }

    public int getExponent()
    {
        return expo;
    }

    public void setExponent(int expo)
    {
        this.expo = expo;
    }

    public int getCoefficient()
    {
        return coeff;
    }

    public void setCoefficient(int coeff)
    {
        this.coeff = coeff;
    }

    public void setAll(int c, int e) {
        this.coeff = c;
        this.expo = e;
    }

    public Term clone()
    {
        Term t = new Term();
        t.setCoefficient(this.getCoefficient());
        t.setExponent(this.getExponent());
        return t;
    }

    public String toString()
    {
        if (getCoefficient() == 0)
        {
            return "";
        }
        else if (getExponent() == 0)
        {
            if (getCoefficient() > 0)
            {
                return "+" + getCoefficient();
            }
            return Integer.toString(getCoefficient());
        }
        else if (getExponent() == 1)
        {
            if (getCoefficient() == 1)
            {
                return "+" + "x";
            }
            if (getCoefficient() == -1)
            {
                return "-" + "x";
            }
            if (getCoefficient() > 0)
            {
                return "+" + getCoefficient() + "x";
            }
            return getCoefficient() + "x";
        }
        else if (getCoefficient() == 1)
        {
            return "+x^" + getExponent();
        }
        else if (getCoefficient() == -1)
        {
            return "-x^" + getExponent();
        }
        else
        {
            if (getCoefficient() > 0)
            {
                return "+" + getCoefficient() + "x^" + getExponent();
            }
            return getCoefficient() + "x^" + getExponent();
        }
    }

    public int compareTo(Term other) {
        if (other.getExponent() == this.getExponent())
        {
            return 0;
        }
        if (other.getExponent() > this.getExponent())
        {
            return -1;
        }
        else
        {
            return 1;
        }

    }
}
