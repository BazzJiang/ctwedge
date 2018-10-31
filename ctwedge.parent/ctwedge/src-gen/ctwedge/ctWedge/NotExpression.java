/**
 * generated by Xtext 2.15.0
 */
package ctwedge.ctWedge;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ctwedge.ctWedge.NotExpression#getPredicate <em>Predicate</em>}</li>
 * </ul>
 *
 * @see ctwedge.ctWedge.CtWedgePackage#getNotExpression()
 * @model
 * @generated
 */
public interface NotExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Predicate</em>' containment reference.
   * @see #setPredicate(Expression)
   * @see ctwedge.ctWedge.CtWedgePackage#getNotExpression_Predicate()
   * @model containment="true"
   * @generated
   */
  Expression getPredicate();

  /**
   * Sets the value of the '{@link ctwedge.ctWedge.NotExpression#getPredicate <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Predicate</em>' containment reference.
   * @see #getPredicate()
   * @generated
   */
  void setPredicate(Expression value);

} // NotExpression
