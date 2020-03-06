package viewmodel;

import model.HeaterModel;

public class ViewModelFactory {
    private MainViewModel mainViewModel;
    private SecondaryViewModel secondaryViewModel;

    public ViewModelFactory(HeaterModel model) {
        mainViewModel = new MainViewModel(model);
        secondaryViewModel = new SecondaryViewModel(model);
    }

    public MainViewModel getHeaterViewModel() {
        return mainViewModel;
    }
    public SecondaryViewModel getSecondaryViewModel(){
        return secondaryViewModel;
    }
}
