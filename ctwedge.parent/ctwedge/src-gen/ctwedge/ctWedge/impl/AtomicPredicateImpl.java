/**
 * generated by Xtext 2.15.0
 */
package ctwedge.ctWedge.impl;

import ctwedge.ctWedge.AtomicPredicate;
import ctwedge.ctWedge.CtWedgePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ctwedge.ctWedge.impl.AtomicPredicateImpl#getBoolConst <em>Bool Const</em>}</li>
 *   <li>{@link ctwedge.ctWedge.impl.AtomicPredicateImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AtomicPredicateImpl extends ExpressionImpl implements AtomicPredicate
{
  /**
   * The default value of the '{@link #getBoolConst() <em>Bool Const</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolConst()
   * @generated
   * @ordered
   */
  protected static final String BOOL_CONST_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBoolConst() <em>Bool Const</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolConst()
   * @generated
   * @ordered
   */
  protected String boolConst = BOOL_CONST_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AtomicPredicateImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CtWedgePackage.Literals.ATOMIC_PREDICATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBoolConst()
  {
    return boolConst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoolConst(String newBoolConst)
  {
    String oldBoolConst = boolConst;
    boolConst = newBoolConst;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CtWedgePackage.ATOMIC_PREDICATE__BOOL_CONST, oldBoolConst, boolConst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CtWedgePackage.ATOMIC_PREDICATE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CtWedgePackage.ATOMIC_PREDICATE__BOOL_CONST:
        return getBoolConst();
      case CtWedgePackage.ATOMIC_PREDICATE__NAME:
        return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CtWedgePackage.ATOMIC_PREDICATE__BOOL_CONST:
        setBoolConst((String)newValue);
        return;
      case CtWedgePackage.ATOMIC_PREDICATE__NAME:
        setName((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CtWedgePackage.ATOMIC_PREDICATE__BOOL_CONST:
        setBoolConst(BOOL_CONST_EDEFAULT);
        return;
      case CtWedgePackage.ATOMIC_PREDICATE__NAME:
        setName(NAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CtWedgePackage.ATOMIC_PREDICATE__BOOL_CONST:
        return BOOL_CONST_EDEFAULT == null ? boolConst != null : !BOOL_CONST_EDEFAULT.equals(boolConst);
      case CtWedgePackage.ATOMIC_PREDICATE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (boolConst: ");
    result.append(boolConst);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //AtomicPredicateImpl
