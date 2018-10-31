/**
 * generated by Xtext 2.15.0
 */
package ctwedge.ctWedge;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ctwedge.ctWedge.RelationalExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link ctwedge.ctWedge.RelationalExpression#getOp <em>Op</em>}</li>
 *   <li>{@link ctwedge.ctWedge.RelationalExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see ctwedge.ctWedge.CtWedgePackage#getRelationalExpression()
 * @model
 * @generated
 */
public interface RelationalExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see ctwedge.ctWedge.CtWedgePackage#getRelationalExpression_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link ctwedge.ctWedge.RelationalExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link ctwedge.ctWedge.Operators}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see ctwedge.ctWedge.Operators
   * @see #setOp(Operators)
   * @see ctwedge.ctWedge.CtWedgePackage#getRelationalExpression_Op()
   * @model
   * @generated
   */
  Operators getOp();

  /**
   * Sets the value of the '{@link ctwedge.ctWedge.RelationalExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see ctwedge.ctWedge.Operators
   * @see #getOp()
   * @generated
   */
  void setOp(Operators value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see ctwedge.ctWedge.CtWedgePackage#getRelationalExpression_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link ctwedge.ctWedge.RelationalExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // RelationalExpression
