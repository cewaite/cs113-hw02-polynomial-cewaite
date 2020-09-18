package edu.miracosta.cs113;

import java.util.LinkedList;

public class Polynomial {

    private LinkedList<Term> polynomial = new LinkedList<Term>();

//  Default Constructor
    Polynomial() {}

//  Full Constructor
    Polynomial(Term t)
    {
        polynomial.add(t);
    }

    Polynomial (LinkedList<Term> t)
    {
        this.polynomial = t;
    }

//  Copy Constructor
    Polynomial(Polynomial other)
    {
        this(other.getLinkedList());
    }

    public LinkedList<Term> getLinkedList()
    {
        return polynomial;
    }

    public void clear()
    {
        int j = polynomial.size();
        for (int i = 0; i < j; i++)
        {
            polynomial.remove();
        }
//        polynomial.clear();
    }

    public void addTerm(Term t)
    {
        boolean added = false;
        boolean duplicate = false;
        int addTo = 0;
        if (this.getLinkedList().size() == 0)
        {
            polynomial.add(t);
        }
        else
        {
            for (int i = 0; i < polynomial.size(); i++)
            {
                if (t.getExponent() == polynomial.get(i).getExponent())
                {
                    if (t.getCoefficient() != polynomial.get(i).getCoefficient())
                    {
                        polynomial.set(i, new Term((polynomial.get(i).getCoefficient() + t.getCoefficient()), t.getExponent()));
                        added = true;
                    }
                    else if (t.getCoefficient() == polynomial.get(i).getCoefficient())
                    {
                        duplicate = true;
                    }
                }
            }
            if (added == false && duplicate == false)
            {
                if (t.getExponent() > polynomial.get(0).getExponent())
                {
                    polynomial.add(0, t);
                    added = true;
                }
                else
                {
                    for (int i = 0; i < polynomial.size(); i++)
                    {
                        if (t.getExponent() < polynomial.get(i).getExponent())
                        {
                            addTo = i + 1;
                        }
                    }
                    polynomial.add(addTo, t);
                }
            }
        }
    }

    public Term getTerm(int i)
    {
        return this.polynomial.get(i);
    }

    public void add(Polynomial other)
    {
        boolean added = false;
        Polynomial newPolynomial = new Polynomial();
        for (int j = 0; j < this.polynomial.size(); j++)
        {
            for (int i = 0; i < other.getLinkedList().size(); i++)
            {
                if (getTerm(j).getExponent() == other.getTerm(i).getExponent())
                {
                    int addedCoefficients = getTerm(j).getCoefficient() + other.getTerm(i).getCoefficient();
                    newPolynomial.addTerm(new Term(addedCoefficients, getTerm(j).getExponent()));
                    added = true;
                }
            }
            if (added = false)
            {
                newPolynomial.addTerm(new Term(getTerm(j).getCoefficient(), getTerm(j).getExponent()));
            }
            added = false;
        }
        added = false;
        for (int j = 0; j < other.getLinkedList().size(); j++)
        {
            for (int i = 0; i < newPolynomial.getLinkedList().size(); i++)
            {
                if (other.getTerm(j).getExponent() == newPolynomial.getTerm(i).getExponent())
                {
                    added = true;
                }
            }
            if (added == false)
            {
                newPolynomial.addTerm(new Term(other.getTerm(j).getCoefficient(), other.getTerm(j).getExponent()));
            }
        }
        this.polynomial = newPolynomial.getLinkedList();
    }

    public int getNumTerms()
    {
        return polynomial.size();
    }

    public String toString()
    {
        String polynomialString = "";
        if (this.polynomial.size() == 0)
        {
            return "0";
        }
        for (int i = 0; i < this.polynomial.size(); i++)
        {
            if (polynomial.get(i).getCoefficient() > 0)
            {
                polynomialString = polynomialString + polynomial.get(i).toString();
                if (i == 0)
                {
                    polynomialString = polynomialString.replaceFirst("\\+", "");
                }
            }
            else if (polynomial.get(i).getCoefficient() < 0)
            {
                polynomialString = polynomialString + polynomial.get(i).toString();;
            }
        }
        return polynomialString;
    }
}
