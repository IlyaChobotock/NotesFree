package ru.geekbrains.notesfree;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

public class OpenNote extends Fragment {
    private static final String ARG_INDEX = "index";
    private int index;

    // Фабричный метод создания фрагмента
    public static OpenNote newInstance(int index) {
        OpenNote f = new OpenNote(); // создание
        // Передача параметра
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    // Взята заготовка из методички. Исправить
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Получаем головной элемент из макета
        View view = inflater.inflate(R.layout.fragment_open_note, container,
                false);
        // Находим в контейнере элемент-изображение
        AppCompatImageView imageCoatOfArms =
                view.findViewById(R.id.coat_of_arms);
        // Получить из ресурсов массив указателей на изображения гербов
        TypedArray images =
                getResources().obtainTypedArray(R.array.coat_of_arms_imgs);
        // Выбрать по индексу подходящий
        imageCoatOfArms.setImageResource(images.getResourceId(index, -1));
        return view;
    }
}