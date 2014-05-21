//------------------------------------------------------------------------------------------------//
//                                                                                                //
//                                 F l a g S t e m R e l a t i o n                                //
//                                                                                                //
//------------------------------------------------------------------------------------------------//
// <editor-fold defaultstate="collapsed" desc="hdr">
//  Copyright © Herve Bitteur and others 2000-2014. All rights reserved.
//  This software is released under the GNU General Public License.
//  Goto http://kenai.com/projects/audiveris to report bugs or suggestions.
//------------------------------------------------------------------------------------------------//
// </editor-fold>
package omr.sig;

import omr.constant.Constant;
import omr.constant.ConstantSet;

import omr.sheet.Scale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class {@code FlagStemRelation} represents the relation support between a flag and a
 * stem.
 *
 * @author Hervé Bitteur
 */
public class FlagStemRelation
        extends AbstractConnection
{
    //~ Static fields/initializers -----------------------------------------------------------------

    private static final Constants constants = new Constants();

    private static final Logger logger = LoggerFactory.getLogger(FlagStemRelation.class);

    //~ Instance fields ----------------------------------------------------------------------------
    /** Which part of stem is used?. */
    private StemPortion stemPortion;

    //~ Constructors -------------------------------------------------------------------------------
    /**
     * Creates a new FlagStemRelation object.
     */
    public FlagStemRelation ()
    {
    }

    //~ Methods ------------------------------------------------------------------------------------
    @Override
    public String getName ()
    {
        return "Flag-Stem";
    }

    /**
     * @return the stem Portion
     */
    public StemPortion getStemPortion ()
    {
        return stemPortion;
    }

    //------------------//
    // getXInGapMaximum //
    //------------------//
    public static Scale.Fraction getXInGapMaximum ()
    {
        return constants.xInGapMax;
    }

    //-------------------//
    // getXOutGapMaximum //
    //-------------------//
    public static Scale.Fraction getXOutGapMaximum ()
    {
        return constants.xOutGapMax;
    }

    //----------------//
    // getYGapMaximum //
    //----------------//
    public static Scale.Fraction getYGapMaximum ()
    {
        return constants.yGapMax;
    }

    /**
     * @param stemPortion the stem portion to set
     */
    public void setStemPortion (StemPortion stemPortion)
    {
        this.stemPortion = stemPortion;
    }

    @Override
    protected Scale.Fraction getXInGapMax ()
    {
        return getXInGapMaximum();
    }

    @Override
    protected Scale.Fraction getXOutGapMax ()
    {
        return getXOutGapMaximum();
    }

    @Override
    protected Scale.Fraction getYGapMax ()
    {
        return getYGapMaximum();
    }

    @Override
    protected String internals ()
    {
        StringBuilder sb = new StringBuilder(super.internals());
        sb.append(" ").append(stemPortion);

        return sb.toString();
    }

    //~ Inner Classes ------------------------------------------------------------------------------
    //-----------//
    // Constants //
    //-----------//
    private static final class Constants
            extends ConstantSet
    {
        //~ Instance fields ------------------------------------------------------------------------

        final Scale.Fraction yGapMax = new Scale.Fraction(
                0.4,
                "Maximum vertical gap between stem & flag");

        final Scale.Fraction xInGapMax = new Scale.Fraction(
                0.3,
                "Maximum horizontal overlap between stem & flag");

        final Scale.Fraction xOutGapMax = new Scale.Fraction(
                0.3,
                "Maximum horizontal gap between stem & flag");
    }
}