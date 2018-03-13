package com.example.ryzizub.mvcdemo.View;

import android.view.View;

import com.example.ryzizub.mvcdemo.Model.BaseModel;


/**
 * Základní třída pro view transakcí v MVC.
 * <p>
 * Všechny potomci mohou odkazovat přímý odkaz na konkrétní grafické komponenty. Je to také
 * jediné místo, kde dle vzoru MVC tyto odkazy mohou existovat. Jidne než z tříd view, dědících z
 * {@link BaseView}, by se tyto prvky neměly nijak obsluhovat, ani by se na ně nemělo odkazovat.
 *
 * @param <D> specifikuje typ dat, s kterými toto view a potažmo i transakce pracuje
 * @param <C> specifikuje typ callbacku - každá transakce má svůj definovaný callback
 */
public abstract class BaseView<D extends BaseModel, C extends BaseView.IViewCallbackBase> {
    /**
     * ID resource layoutu tohoto view
     */
    private final int layoutRes;
    private final C viewCallback;

    protected BaseView(int layoutRes, C viewCallback) {
        this.layoutRes = layoutRes;
        this.viewCallback = viewCallback;
    }

    protected C getViewCallback() {
        return viewCallback;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    /**
     * Metoda sloužící k nalezení prvků z layoutu a jejich inicializaci.
     *
     * @param parentView
     */
    public abstract void initializeView(View parentView);

    /**
     * Refresh komponent na základě zpracovávaného modelu. Jinde než zde naše view vůbec nemá
     * přístup k modelu, což je pro vhodné pro soudržnost, srozumitelnost a celkový koncept celé
     * aplikace.
     * <p>
     * Slouží pro komunikaci controller -> view v MVC.
     */
    public abstract void refresh(D model);

    /**
     * Základní rozhraní pro view callback. Tento callback si každé view implementuje samo. Nemá
     * žádné metody, ale může mít, pokud bychom našli nějakou událost, kterou z principu mohou
     * vyvolat všechny, ale opravdu VŠECHNY, i budoucí transakce.
     * <p>
     * Slouží pro komunikaci view -> controller v MVC.
     */
    public interface IViewCallbackBase {
    }
}
